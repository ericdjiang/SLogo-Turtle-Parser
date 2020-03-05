package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;
import java.util.Map;

public class Power implements Command {
    private static final int FIRST = 0;
    private static final int SECOND = 1;

    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModelContainer turtleModelContainer, TurtleModel turtleModel) {
        consoleModel.setReturnVal(Math.pow(Double.parseDouble(parameters.get(FIRST)),Double.parseDouble(parameters.get(SECOND))));
        return Math.pow(Double.parseDouble(parameters.get(FIRST)),Double.parseDouble(parameters.get(SECOND)));
    }

    @Override
    public int getNumParams() {
        return 2;
    }
}
