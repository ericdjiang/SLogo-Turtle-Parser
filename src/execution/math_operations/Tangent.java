package execution.math_operations;

import execution.Command;
import model.TurtleModel;

import java.util.List;

public class Tangent implements Command {

    @Override
    public double execute(List<Double> parameters, TurtleModel turtleModel) {
        System.out.println("Tangent of " + parameters.get(0));
        return Math.tan((parameters.get(0)*Math.PI)/180);
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
