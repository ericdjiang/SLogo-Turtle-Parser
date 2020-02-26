package execution.all_commands;

import execution.Command;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class PenDown implements Command {
    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel) {
        turtleModel.makePenDown();
        return 1;
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
