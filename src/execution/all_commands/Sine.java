package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;
import java.util.Map;

public class Sine implements Command {
    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModelContainer turtleModelContainer) {
        System.out.println("Sine of " + parameters.get(0));
        consoleModel.setReturnVal(Math.sin((Double.parseDouble(parameters.get(0))*Math.PI)/180));
        return Math.sin((Double.parseDouble(parameters.get(0))*Math.PI)/180);
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
