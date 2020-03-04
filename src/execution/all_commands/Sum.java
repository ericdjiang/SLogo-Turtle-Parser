package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;
import java.util.Map;

public class Sum implements Command {

    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModelContainer turtleModelContainer) {
        double sum = Double.parseDouble(parameters.get(0)) + Double.parseDouble(parameters.get(1));
        System.out.println(sum);
        consoleModel.setReturnVal(sum);
        return sum;
    }


    @Override
    public int getNumParams() {
        return 2;
    }
}
