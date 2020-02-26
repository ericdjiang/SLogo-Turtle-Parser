package execution.math_operations;

import execution.Command;
import model.TurtleModel;

import java.util.List;

public class Sine implements Command {

    @Override
    public double execute(List<Double> parameters, TurtleModel turtleModel) {
        System.out.println("Sine of " + parameters.get(0));
        return Math.sin((parameters.get(0)*Math.PI)/180);
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
