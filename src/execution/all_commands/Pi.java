package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;
import java.util.Map;

public class Pi implements Command {

    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModel turtleModel) {
        consoleModel.setReturnVal(Math.PI);
        return Math.PI;
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
