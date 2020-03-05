package execution.all_commands;

import execution.Command;
import java.util.List;
import java.util.Map;

import model.*;

public class GreaterThan implements Command {
    private static final int FIRST = 0;
    private static final int SECOND = 1;

    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModelContainer turtleModelContainer, TurtleModel turtleModel) {
        if(Double.parseDouble(parameters.get(SECOND)) > Double.parseDouble(parameters.get(FIRST))) {
            consoleModel.setReturnVal(1);
            return 1;
        }
        consoleModel.setReturnVal(0);
        return 0;
    }

    @Override
    public int getNumParams() {
        return 2;
    }
}
