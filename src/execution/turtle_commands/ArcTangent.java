package execution.turtle_commands;

import execution.Command;
import model.TurtleModel;

import java.util.List;

public class ArcTangent implements Command {
    @Override
    public double execute(List<Double> parameters, TurtleModel turtleModel) {
        System.out.println("Arctangent of " + parameters.get(0));
        return Math.atan((parameters.get(0)*Math.PI)/180);
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
