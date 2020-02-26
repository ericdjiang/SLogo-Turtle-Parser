package execution.turtle_commands;

import execution.Command;
import model.ConsoleModel;
import model.TurtleModel;

import java.util.List;

public class SetHeading implements Command {

    @Override
    public double execute(List<Double> parameters, TurtleModel turtleModel, ConsoleModel consoleModel) {
        System.out.println("turns turtle to an absolute heading by " +parameters.get(0) + " degrees");
        return parameters.get(0);
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
