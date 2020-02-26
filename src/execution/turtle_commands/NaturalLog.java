package execution.turtle_commands;

import execution.Command;
import model.TurtleModel;

import java.util.List;

public class NaturalLog implements Command {
    @Override
    public double execute(List<Double> parameters, TurtleModel turtleModel) {
        System.out.println("Natural Log of" + parameters.get(0));
        return Math.log(parameters.get(0));
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
