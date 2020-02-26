package execution.math_operations;

import execution.Command;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class Quotient implements Command {
    @Override
    public double execute(List<Double> parameters, TurtleModel turtleModel, VariableModel variableModel) {
        System.out.println("Quotient of " + parameters.get(0) + "and " + parameters.get(1));
        return parameters.get(0)/parameters.get(1);
    }

    @Override
    public int getNumParams() {
        return 2;
    }
}
