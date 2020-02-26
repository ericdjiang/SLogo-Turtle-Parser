package execution.turtle_commands;

import execution.Command;
import model.TurtleModel;

import java.util.List;

public class Cosine implements Command {


    @Override
    public double execute(List<Double> parameters, TurtleModel turtleModel) {
        System.out.println("Cosine of " + parameters.get(0));
        return Math.cos((parameters.get(0)*Math.PI)/180);
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
