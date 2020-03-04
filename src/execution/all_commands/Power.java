package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;
import java.util.Map;

public class Power implements Command {

    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModelContainer turtleModelContainer, TurtleModel currentTurtleModel) {
        System.out.println(parameters.get(0) + "to the " + parameters.get(1));
        consoleModel.setReturnVal(Math.pow(Double.parseDouble(parameters.get(0)),Double.parseDouble(parameters.get(1))));
        return Math.pow(Double.parseDouble(parameters.get(0)),Double.parseDouble(parameters.get(1)));
    }

    @Override
    public int getNumParams() {
        return 2;
    }
}
