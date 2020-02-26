package execution.math_operations;

import execution.Command;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class Pi implements Command {

    @Override
    public double execute(List<Double> parameters, TurtleModel turtleModel, VariableModel variableModel) {
        System.out.println(Math.PI);
        return Math.PI;
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
