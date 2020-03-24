package execution;

import java.lang.reflect.InvocationTargetException;

/**
 * Responsible for generating the corresponding class
 * within all_commands for a given input string
 */
public class CommandFactory {
    private static final String PACKAGE = "execution.all_commands.";

    /**
     * Takes in a String which corresponds to the command
     * @param command the String representation of the command from Resources file
     * @return the Command object constructed from the string
     */
    public Command getCommand(String command) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class c = Class.forName(PACKAGE + command);
        Command command1 = (Command) c.getConstructor().newInstance();
        return command1;
    }

}
