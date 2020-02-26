package execution.turtle_commands;

import execution.Command;
import model.TurtleModel;

import java.util.List;

public class Power implements Command {

    @Override
    public double execute(List<Double> parameters, TurtleModel turtleModel) {
        System.out.println(parameters.get(0) + "to the " + parameters.get(1));
        return Math.pow(parameters.get(0), parameters.get(1));
    }

    @Override
    public int getNumParams() {
        return 2;
    }
}
