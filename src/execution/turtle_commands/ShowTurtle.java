package execution.turtle_commands;

import execution.Command;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class ShowTurtle implements Command {
    @Override
    public double execute(List<Double> parameters, TurtleModel turtleModel, VariableModel variableModel) {
        turtleModel.showTurtle();
        return 1;
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
