package execution.variable_commands;

import execution.Command;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class Make implements Command {
    @Override
    public double execute(List<Double> parameters, TurtleModel turtleModel, VariableModel variableModel) {
        return 0;
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
