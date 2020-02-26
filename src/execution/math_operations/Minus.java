package execution.math_operations;

import execution.Command;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class Minus implements Command {

    @Override
    public double execute(List<Double> parameters, TurtleModel turtleModel, VariableModel variableModel) {
        System.out.println("Negative of " + parameters.get(0));
        return -1*parameters.get(0);
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
