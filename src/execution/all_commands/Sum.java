package execution.all_commands;

import execution.Command;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class Sum implements Command {

    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel) {
        double sum = Double.parseDouble(parameters.get(0)) + Double.parseDouble(parameters.get(1));
        return sum;
    }


    @Override
    public int getNumParams() {
        return 2;
    }
}
