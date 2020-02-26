package execution.boolean_operations;

import execution.Command;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class LessThan implements Command {

    @Override
    public double execute(List<Double> parameters, TurtleModel turtleModel, VariableModel variableModel) {
        if(parameters.get(0) < parameters.get(1)){
            System.out.println(1);
            return 1;
        }
        System.out.println(0);
        return 0;
    }

    @Override
    public int getNumParams() {
        return 2;
    }
}
