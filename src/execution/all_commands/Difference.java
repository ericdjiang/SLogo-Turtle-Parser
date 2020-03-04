package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;
import java.util.Map;

public class Difference implements Command {

    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModelContainer turtleModelContainer, TurtleModel currentTurtleModel) {
        double difference = Double.parseDouble(parameters.get(0)) - Double.parseDouble(parameters.get(1));
        consoleModel.setReturnVal(difference);
        return difference;
    }

    @Override
    public int getNumParams() {
        return 2;
    }
}
