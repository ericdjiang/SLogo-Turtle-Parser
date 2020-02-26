package execution.all_commands;

import execution.Command;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class Difference implements Command {

    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel) {
        System.out.println("Difference of " + parameters.get(0) + "and " + parameters.get(1));
        double difference = Double.parseDouble(parameters.get(0)) - Double.parseDouble(parameters.get(1));
        return difference;
    }

    @Override
    public int getNumParams() {
        return 2;
    }
}
