package parsing;

import execution.Command;
import execution.CommandFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.regex.Pattern;

import model.ConsoleModel;
import model.MethodModel;
import model.TurtleModel;
import model.VariableModel;

public class Parser {

    private static final String RESOURCES = "resources/languages";
    private static final String DEFAULT_RESOURCE_PACKAGE = RESOURCES + ".";
    private List<Map.Entry<String, Pattern>> mySymbols;
    private CommandFactory factory = new CommandFactory();
    private ResourceBundle resourceBundle;

    private String myLanguage;
    private VariableModel myVariableModel;
    private ConsoleModel myConsoleModel;
    private Double lastReturnValue;

    private Map<String, MethodModel> myMethodModels;

    private TurtleModel myTurtleModel;
    private static final Map<String, Integer> LOOP_MAPPINGS = new HashMap<String, Integer>() {{
        put("repeat", 1);
        put("dotimes", 2);
        put("for", 2);

        put("if", 1);
        put("ifelse", 2);

        put("to", 2);
    }};

    public Parser(String commands, String language, TurtleModel myTurtleModel,
        VariableModel myVariableModel, ConsoleModel myConsoleModel,
        Map<String, MethodModel> myMethodModels) {
        this.myTurtleModel = myTurtleModel;
        this.myVariableModel = myVariableModel;
        this.myConsoleModel = myConsoleModel;
        this.myLanguage = language;
        this.myMethodModels = myMethodModels;

        resourceBundle = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);

        addPatterns(language);

        try {
            parseText(commands);
        }catch( Exception e){
            System.out.println("error");
            String messgae = resourceBundle.getString("ErrorInput");
            myConsoleModel.setErrorMessage(messgae);

        }
    }

    private boolean validateMessage() {
        return false;
    }

    private void parseText(String commands)
        throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException {
        List<String> fullList = Arrays.asList(commands.split("\n"));
        List<String> newList = new ArrayList<String>(fullList);
        for(String line: fullList){
            if(line.startsWith("#")){
                newList.remove(line);
            }
        }
        commands = String.join(" ", newList);
        List<String> symbolList = Arrays
            .asList(String.join(" ", commands.toLowerCase().split("\n")).split("[ ]+"));

//        System.out.println("INSIDE Parser: " + commands);

        Stack<String> cmdStack = new Stack<>();
        Stack<String> argStack = new Stack<>();

        // iterate thru commands in popped element;
        int loopEndIndex = -1;
//            String symbol = symbolList.get(cursor).strip();
//            Command factoryCommand = factory.getCommand(getSymbol(symbol));
//            cmdStack.push(factoryCommand);
        if (symbolList.size() == 1 && !symbolList.get(0)
            .matches("[-+*\\/]?[a-zA-Z_]+(\\?)?")) { // for parsing within loop guard
            if (symbolList.get(0).matches(":[a-zA-Z_]+")) {
                lastReturnValue = myVariableModel.getValue(symbolList.get(0));
            } else {
                lastReturnValue = Double.parseDouble(symbolList.get(0));
            }
            ;
        }

        for (int cursor = 0; cursor < symbolList.size(); cursor++) {

            if (cursor > loopEndIndex) {
                String symbol = symbolList.get(cursor).strip();
//                    System.out.println(symbol);

                //if the symbol is a command
                if (LOOP_MAPPINGS.containsKey(symbol)) {
                    loopEndIndex = handleLoop(symbolList, cmdStack, argStack, cursor, symbol);
                } else if (symbol.matches("^[-+*\\/a-zA-Z_]+(\\?)?$")) {
                    cmdStack.push(symbol); //factory.getCommand(getSymbol(symbol))
                } else { // if symbol is a number
                    argStack.push(symbol);
                }
//                    System.out.println();
//
//                    System.out.println(cursor);
//                    System.out.println(cmdStack);
//                    System.out.println(argStack);

//                    System.out.println(getNumParams(cmdStack.peek()));
                while (!cmdStack.isEmpty() &&
                    (
                        (myMethodModels.containsKey(cmdStack.peek()) && argStack.size() >= myMethodModels.get(cmdStack.peek()).getNumVariables())
                        ||
                        (!myMethodModels.containsKey(cmdStack.peek()) && argStack.size() >= getNumParams(cmdStack.peek())) // for standard command
                    )

                ) {

//                    System.out.println("Peeking");
//                    System.out.println(cmdStack.peek());
//                    System.out.println(myMethodModels.containsKey(cmdStack.peek()));
                    if(myMethodModels.containsKey(cmdStack.peek())){
                        String methodName = cmdStack.pop();

                        MethodModel myMethodModel = myMethodModels.get(methodName);

                        List<String> params = new ArrayList<>();
                        while (myMethodModel.getNumVariables() > params.size()) {
                            String popped = argStack.pop();
                            params.add(popped);
                        }
                        Collections.reverse(params);

                        for(int i = 0; i < params.size(); i++) {
                            List <String> varNameAndValue = new ArrayList<>();
                            varNameAndValue.add(myMethodModel.getVariableName(i));
                            varNameAndValue.add(params.get(i));
                            factory.getCommand(getSymbol("make")).execute(varNameAndValue, myTurtleModel, myVariableModel, myConsoleModel,
                                myMethodModels);
                        }

                        Parser parser = new Parser(myMethodModel.getMethodBody(), myLanguage, myTurtleModel, myVariableModel, myConsoleModel, myMethodModels);
                        lastReturnValue = parser.getLastReturnValue();

                    } else if (cmdStack.size() >= 2 &&
                        (
                            getNumParams(cmdStack.size() - 2, cmdStack) == 1 && getNumParams(cmdStack.size() - 2, cmdStack) > argStack.size()
                                // and fd 30 bk 20
                                ||
                            getNumParams(cmdStack.size() - 2, cmdStack) == 2 && getNumParams(cmdStack.size() - 2, cmdStack) >= argStack.size() // make :var sum 20 30
                        )
                    ) {
                        break;
                    } else {
                        Command cmdToExecute = factory.getCommand(getSymbol(cmdStack.pop()));
                        List<String> params = new ArrayList<>();
                        while (cmdToExecute.getNumParams() > params.size()) {
                            String popped = argStack.pop();

                            // check if the argument is a variable, and convert it to double if the command is not make
                            if (!cmdToExecute.getClass().getSimpleName().equals("MakeVariable")
                                && popped.matches(":[a-zA-Z_]+")) {
                                popped = Double.toString(myVariableModel.getValue(popped));
                            }

                            params.add(popped);
                        }
                        Collections.reverse(params);
                        Double returnValue = cmdToExecute
                            .execute(params, myTurtleModel, myVariableModel, myConsoleModel,
                                myMethodModels);
                        this.lastReturnValue = returnValue;
                        if (!cmdStack.isEmpty()) {
                            argStack.push(returnValue.toString());
                        }

                    }
                }
            }

        }


    }


    private int getNumParams(int index, Stack<String> commandStack)
        throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return factory.getCommand(getSymbol(commandStack.get(index))).getNumParams();
    }

    private int getNumParams(String symbol)
        throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException
        {
//            System.out.println("Getting factory for symbol: "+ symbol);
            return factory.getCommand(getSymbol(symbol)).getNumParams();
        }

        public Double getLastReturnValue () {
            return lastReturnValue;
        }
        ;

        private int handleLoop
        (List < String > symbolList, Stack < String > cmdStack, Stack < String > argStack,
        int cursor, String symbol)
        throws
        ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
        {
            cmdStack.push(symbol);
            int loopEndIndex = getLoopEndIndex(symbolList, cursor, symbol);

            List<String> argsWithLanguage = new ArrayList<>(
                symbolList.subList(cursor + 1, loopEndIndex));
            argsWithLanguage.add(0, myLanguage);
            argStack.push(String.join(" ", argsWithLanguage));
            return loopEndIndex;
        }

        private int getLoopEndIndex (List < String > symbolList,int loopStartIndex, String cmdString)
        {
            int openBracketCount = 0;
            int closeBracketCount = 0;

            int cursor = loopStartIndex; //the index of the command symbol
            while (openBracketCount > closeBracketCount || closeBracketCount < LOOP_MAPPINGS
                .get(cmdString)) {
                cursor += 1;
                String symbol = symbolList.get(cursor).strip();
                if (symbol.equals("]")) {
                    closeBracketCount += 1;
                } else if (symbol.equals("[")) {
                    openBracketCount += 1;
                }
            }
            return cursor;
        }

        private List<String> getLoopBody (List < String > symbolList,int loopStartIndex){
            int loopEndIndex = -1;
            for (int i = 0; i < symbolList.size(); i++) {
                if (symbolList.get(i).equals("]")) {
                    loopEndIndex = i;
                }
            }
            return symbolList.subList(loopStartIndex, loopEndIndex - 1);
        }

        /**
         * Adds the given resource file to this language's recognized types
         */
        public void addPatterns (String syntax){
            mySymbols = new ArrayList<>();
            ResourceBundle resources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + syntax);
            for (String key : Collections.list(resources.getKeys())) {
                String regex = resources.getString(key);
                mySymbols.add(new AbstractMap.SimpleEntry<>(key,
                    // THIS IS THE IMPORTANT LINE
                    Pattern.compile(regex, Pattern.CASE_INSENSITIVE)));
            }
        }

        /**
         * Returns language's type associated with the given text if one exists
         */
        private String getSymbol (String text){
            final String ERROR = "NoMatch";
            for (Map.Entry<String, Pattern> e : mySymbols) {
                if (match(text, e.getValue())) {
//                    System.out.println(e.getKey());
                    return e.getKey();
                }
            }
            // FIXME: perhaps throw an exception instead
            return ERROR;
        }

        // Returns true if the given text matches the given regular expression pattern
        private boolean match (String text, Pattern regex){
            // THIS IS THE IMPORTANT LINE
            return regex.matcher(text).matches();
        }
    }

