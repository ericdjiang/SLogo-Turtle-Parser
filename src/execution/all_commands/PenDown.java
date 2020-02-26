package execution.all_commands;

import execution.Command;
import model.ConsoleModel;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class PenDown implements Command {
    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel, ConsoleModel consoleModelv) {
        turtleModel.makePenDown();
        return 1;
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
