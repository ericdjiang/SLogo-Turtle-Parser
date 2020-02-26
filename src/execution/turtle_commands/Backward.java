package execution.turtle_commands;

import execution.Command;
import java.util.List;
import model.TurtleModel;

public class Backward implements Command {
    @Override
    public double execute(List<Double> parameters, TurtleModel turtleModel) {
        System.out.println("Moving backwards by: "+ parameters.get(0));
        return parameters.get(0);
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
