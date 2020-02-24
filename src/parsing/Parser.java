package parsing;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Pattern;

public class Parser {
    private static final String RESOURCES_PACKAGE = Parser.class.getPackageName() + ".resources.";
    private List<Map.Entry<String, Pattern>> mySymbols;
    private Executor executor = new Executor();
    Method[] myMethods = executor.getClass().getMethods();


    public Parser (List<String> lines,String language) throws InvocationTargetException, IllegalAccessException {
        addPatterns(language);
        parseText(lines);
    }


    private boolean validateMessage(){
        return false;
    }


    private void parseText ( List<String> lines) throws InvocationTargetException, IllegalAccessException {
        for (String line : lines) {
            String[] commandAndParam = line.split(" ");
            String command = commandAndParam[0];
            int param = Integer.parseInt(commandAndParam[1]);
            if (line.trim().length() > 0) {
                for(Method method : myMethods){
                    if(getSymbol(command).equals(method.getName())){
                        method.invoke(executor,param);
                    }
                }
            }
        }
        // FIXME: Only works for commands with only one parameter of type int
        //FIXME: Only works for one line
    }

        /**
         * Adds the given resource file to this language's recognized types
         */
        private void addPatterns (String syntax) {
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



