package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;
import java.util.Map;

public class Product implements Command {

    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModelContainer turtleModelContainer) {
        System.out.println("Product of " + parameters.get(0) + "and " + parameters.get(1));
        consoleModel.setReturnVal(Double.parseDouble(parameters.get(0))*Double.parseDouble(parameters.get(1)));
        return Double.parseDouble(parameters.get(0))*Double.parseDouble(parameters.get(1));
    }

    @Override
    public int getNumParams() {
        return 2;
    }
}
