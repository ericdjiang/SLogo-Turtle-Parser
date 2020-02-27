package execution.all_commands;

import execution.Command;
import model.ConsoleModel;
import model.MethodModel;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;
import java.util.Map;

public class Minus implements Command {
    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels) {
        System.out.println("Negative of " + parameters.get(0));
        consoleModel.setReturnVal(-1*Double.parseDouble(parameters.get(0)));
        return -1*Double.parseDouble(parameters.get(0));
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
