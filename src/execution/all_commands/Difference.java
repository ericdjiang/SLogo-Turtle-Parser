package execution.all_commands;

import execution.Command;
import model.ConsoleModel;
import model.MethodModel;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;
import java.util.Map;

public class Difference implements Command {

    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels) {
        double difference = Double.parseDouble(parameters.get(0)) - Double.parseDouble(parameters.get(1));
        consoleModel.setReturnVal(difference);
        return difference;
    }

    @Override
    public int getNumParams() {
        return 2;
    }
}
