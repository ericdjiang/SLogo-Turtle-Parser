package parsing;

import execution.Command;
import execution.CommandFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.regex.Pattern;
import model.TurtleModel;

public class Parser {
    private static final String RESOURCES_PACKAGE = Parser.class.getPackageName() + ".resources.";
    private List<Map.Entry<String, Pattern>> mySymbols;
    private CommandFactory factory = new CommandFactory();

    private TurtleModel myTurtleModel;
    public Parser (String commands ,String language, TurtleModel myTurtleModel) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InstantiationException {
        addPatterns(language);
        parseText(commands);

        this.myTurtleModel = myTurtleModel;
    }

    private boolean validateMessage(){
        return false;
    }

    private void parseText ( String commands) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException {
        String[] lines = commands.split("\n");
        for (String line : lines) {
            String[] commandAndParams = line.split(" ");
            String command = commandAndParams[0];
            if (line.trim().length() > 0) {
                String symbol = getSymbol(command);
                Command usercommand = factory.getCommand(getSymbol(symbol));
                usercommand.execute(symbol, parameters, myTurtleModel);


            }
        }
        //FIXME: Only works for commands with only one parameter of type int
    }

        /**
         * Adds the given resource file to this language's recognized types
         */
        public void addPatterns(String syntax) {
            mySymbols = new ArrayList<>();
            ResourceBundle resources = ResourceBundle.getBundle(RESOURCES_PACKAGE + syntax);
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
        private String getSymbol (String text) {
            final String ERROR = "NO MATCH";
            for (Map.Entry<String, Pattern> e : mySymbols) {
                if (match(text, e.getValue())) {
                    System.out.println(e.getKey());
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



