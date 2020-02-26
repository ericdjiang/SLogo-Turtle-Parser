package execution.boolean_operations;

import execution.Command;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class GreaterThan implements Command {

    @Override
    public double execute(List<Double> parameters, TurtleModel turtleModel, VariableModel variableModel) {
        if(parameters.get(1) > parameters.get(0)) return 1;
        return 0;
    }

    @Override
    public int getNumParams() {
        return 2;
    }
}
