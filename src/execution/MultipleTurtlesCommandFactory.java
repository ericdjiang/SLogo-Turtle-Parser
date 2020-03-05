package execution;

import java.lang.reflect.InvocationTargetException;

public class MultipleTurtlesCommandFactory {
    private static final String PACKAGE = "execution.all_commands.";
    public MultipleTurtlesCommand getCommand(String command) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class c = Class.forName(PACKAGE + command);

        MultipleTurtlesCommand command1 = (MultipleTurtlesCommand) c.getConstructor().newInstance();

        return command1;
    }
}
