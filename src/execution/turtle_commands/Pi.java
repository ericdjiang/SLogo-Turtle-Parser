package execution.turtle_commands;

import execution.Command;
import model.TurtleModel;

import java.util.List;

public class Pi implements Command {
    @Override
    public double execute(List<Double> parameters, TurtleModel turtleModel) {
        return Math.PI;
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
