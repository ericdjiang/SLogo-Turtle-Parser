package execution.all_commands;

import execution.Command;
import java.util.List;
import java.util.Map;

import model.*;

public class GreaterThan implements Command {

    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModelContainer turtleModelContainer) {
        if(Double.parseDouble(parameters.get(1)) > Double.parseDouble(parameters.get(0))) {
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
