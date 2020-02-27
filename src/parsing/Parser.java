package parsing;

import execution.Command;
import execution.CommandFactory;

import java.io.Console;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.regex.Pattern;

import model.ConsoleModel;
import model.TurtleModel;
import model.VariableModel;

public class Parser {

    private static final String RESOURCES = "resources/languages";
    private static final String DEFAULT_RESOURCE_PACKAGE = RESOURCES + ".";
    private List<Map.Entry<String, Pattern>> mySymbols;
    private CommandFactory factory = new CommandFactory();

    private String myLanguage;
    private VariableModel myVariableModel;
    private ConsoleModel myConsoleModel;
    private TurtleModel myTurtleModel;

    public Parser(String commands, String language, TurtleModel myTurtleModel,
        VariableModel myVariableModel, ConsoleModel myConsoleModel)
        throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InstantiationException {
        this.myTurtleModel = myTurtleModel;
        this.myVariableModel = myVariableModel;
        this.myConsoleModel = myConsoleModel;
        this.myLanguage = language;

        addPatterns(language);

        parseText(commands);
    }

    private boolean validateMessage() {
        return false;
    }

    private void parseText(String commands)

        throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException {
        List<String> inputCommands = Arrays
            .asList(String.join(" ", commands.toLowerCase().split("\n")).split("[ ]+"));

//        for (String line : lines) {
//            List<String> commandAndParams = Arrays.asList(line.strip().split("[ ]+"));
//
//            //extract the command name (e.g. FD)
//            String command = commandAndParams.get(0);
//            if(!command.matches("^[a-zA-Z]+$")) {
//                System.out.println("Invalid command.");
//                return;
//            }
//
//            // populate a list of the parameters
//            List<String> params = new ArrayList<>();
//            // check if there are parameters included with the command symbol
//            if(commandAndParams.size()>1) {
//                params = commandAndParams.subList(1, commandAndParams.size());
//            }
//            // error check the parameters for invalid nonnumeric charactrs
//            for(String param: params){
//                // make sure string is a decimal
//                System.out.println("Parameter: " + param);
//                if (!param.matches("^\\-?[0-9]*\\.?[0-9]*$")) {
//                    System.out.println("Invalid Parameter.");
//                    return;
//                }
//            }
//
//            // Execute the command
//            String symbol = getSymbol(command);
//            Command factoryCommand = factory.getCommand(getSymbol(symbol));
//            if(factoryCommand.getNumParams()==params.size()){
//                factoryCommand.execute(params, myTurtleModel);
//            } else {
//                System.out.println("Invalid number of parameters.");
//            }
//
//        }
        //FIXME: Only works for commands with only one parameter of type int
        Stack<List<String>> stack = new Stack();

        stack.push(inputCommands);

        while (!stack.isEmpty()) {
            List<String> symbolList = stack.pop();

            Stack<Command> cmdStack = new Stack<>();
            Stack<String> argStack = new Stack<>();

            // iterate thru commands in popped element;
            int loopEndIndex = -1;
//            String symbol = symbolList.get(cursor).strip();
//            Command factoryCommand = factory.getCommand(getSymbol(symbol));
//            cmdStack.push(factoryCommand);

            for (int cursor = 0; cursor < symbolList.size(); cursor++) {

                if (cursor > loopEndIndex) {
                    String symbol = symbolList.get(cursor).strip();
                    System.out.println(symbol);

                    //if the symbol is a command
                    if (symbol.equals("repeat")) {
                        loopEndIndex = handleLoop(symbolList, cmdStack, argStack, cursor, symbol, 2);
                    } else if (symbol.equals("dotimes")){
                        loopEndIndex = handleLoop(symbolList, cmdStack, argStack, cursor, symbol, 5);
                    } else if (symbol.equals("for")) {
                        loopEndIndex = handleLoop(symbolList, cmdStack, argStack, cursor, symbol, 7);
                    } else if (symbol.matches("^[a-zA-Z]+$")) {
                        cmdStack.push(factory.getCommand(getSymbol(symbol)));
                    } else { // if symbol is a number
                        argStack.push(symbol);
                    }
//                    System.out.println();
//
                    System.out.println(cursor);
                    System.out.println(cmdStack);
                    System.out.println(argStack);

                    while (!cmdStack.isEmpty() && !argStack.isEmpty() &&
                        argStack.size() >= cmdStack.peek().getNumParams()
                    ) {
                        if(cmdStack.size()>=2 && cmdStack.get(cmdStack.size()-2).getNumParams() > argStack.size()){
                            break;
                        }
                        Command cmdToExecute = cmdStack.pop();
                        List<String> params = new ArrayList<>();
                        while (cmdToExecute.getNumParams() > params.size()) {
                            String popped = argStack.pop();

                            // check if the argument is a variable, and convert it to double if the command is not make
                            if (!cmdToExecute.getClass().getSimpleName().equals("MakeVariable") && popped.matches(":[a-zA-Z_]+")){
                                popped = Double.toString(myVariableModel.getValue(popped));
                            }

                            params.add(popped);
                        }
                        Collections.reverse(params);


                        Double returnValue = cmdToExecute
                            .execute(params, myTurtleModel, myVariableModel, myConsoleModel);
                        if (!cmdStack.isEmpty()) {
                            argStack.push(returnValue.toString());

                        }

                    }
                }

            }
        }


    }

    private int handleLoop(List<String> symbolList, Stack<Command> cmdStack, Stack<String> argStack,
        int cursor, String symbol, int loopStartIndex)
        throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        int loopEndIndex;
        cmdStack.push(factory.getCommand(getSymbol(symbol)));
        loopEndIndex = getLoopEndIndex(symbolList, cursor+loopStartIndex);

        List<String> argsWithLanguage = new ArrayList<>(symbolList.subList(cursor + 1, loopEndIndex));
        argsWithLanguage.add(0, myLanguage);
        argStack.push(String.join(" ", argsWithLanguage));
        return loopEndIndex;
    }


    private int getLoopEndIndex(List<String> symbolList, int loopStartIndex){
        int openBracketCount = 1;
        int closeBracketCount = 0;

        int cursor = loopStartIndex; //the start of the opening bracket
        while (openBracketCount > closeBracketCount) {
            cursor += 1;
            String symbol = symbolList.get(cursor).strip();
            if( symbol.equals("[") ){
                openBracketCount += 1;
            } else if (symbol.equals("]")){
                closeBracketCount += 1;
            }
        }
        return cursor;
    }

    private List<String> getLoopBody(List<String> symbolList, int loopStartIndex){
        int loopEndIndex = -1;
        for (int i = 0; i < symbolList.size(); i++){
            if(symbolList.get(i).equals("]")){
                loopEndIndex = i;
            }
        }
        return symbolList.subList(loopStartIndex, loopEndIndex-1);
    }

    /**
     * Adds the given resource file to this language's recognized types
     */
    public void addPatterns(String syntax) {
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
    private String getSymbol(String text){
        final String ERROR = "NO MATCH";
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
    private boolean match (String text, Pattern regex) {
        // THIS IS THE IMPORTANT LINE
        return regex.matcher(text).matches();
    }
}

