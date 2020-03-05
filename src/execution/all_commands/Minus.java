package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;
import java.util.Map;

public class Minus implements Command {
    private static final int FIRST = 0;
    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModel turtleModel) {
        consoleModel.setReturnVal(-1*Double.parseDouble(parameters.get(FIRST)));
        return -1*Double.parseDouble(parameters.get(FIRST));
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
