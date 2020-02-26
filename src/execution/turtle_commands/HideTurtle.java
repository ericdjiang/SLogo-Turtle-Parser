package execution.turtle_commands;

import execution.Command;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class HideTurtle implements Command {
    @Override
    public double execute(List<Double> parameters, TurtleModel turtleModel, VariableModel variableModel) {
        turtleModel.hideTurtle();
        return 0;
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
