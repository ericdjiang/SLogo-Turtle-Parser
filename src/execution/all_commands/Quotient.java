package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;
import java.util.Map;

public class Quotient implements Command {
    private static final int FIRST = 0;
    private static final int SECOND = 1;
    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModel turtleModel) {
        System.out.println("Quotient of " + parameters.get(0) + "and " + parameters.get(1));
        consoleModel.setReturnVal(Double.parseDouble(parameters.get(FIRST))/Double.parseDouble(parameters.get(SECOND)));
        return Double.parseDouble(parameters.get(FIRST))/Double.parseDouble(parameters.get(SECOND));
    }

    @Override
    public int getNumParams() {
        return 2;
    }
}
