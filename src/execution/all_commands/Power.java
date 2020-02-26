package execution.all_commands;

import execution.Command;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class Power implements Command {

    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel) {
        System.out.println(parameters.get(0) + "to the " + parameters.get(1));
        return Math.pow(Double.parseDouble(parameters.get(0)),Double.parseDouble(parameters.get(1)));
    }

    @Override
    public int getNumParams() {
        return 2;
    }
}