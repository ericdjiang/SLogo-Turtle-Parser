package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;
import java.util.Map;

public class Sum implements Command {
    private static final int FIRST = 0;
    private static final int SECOND = 1;

    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModel turtleModel) {
        double sum = Double.parseDouble(parameters.get(FIRST)) + Double.parseDouble(parameters.get(SECOND));
        System.out.println(sum);
        consoleModel.setReturnVal(sum);
        return sum;
    }


    @Override
    public int getNumParams() {
        return 2;
    }
}
