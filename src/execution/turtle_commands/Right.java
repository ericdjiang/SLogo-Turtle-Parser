package execution.turtle_commands;

import execution.Command;
import model.ConsoleModel;
import model.TurtleModel;

import java.util.List;

public class Right implements Command {
    @Override
    public double execute(List<Double> parameters, TurtleModel turtleModel, ConsoleModel consoleModel) {
        System.out.println("Rotating Right by: "+ parameters.get(0));
        turtleModel.setAngle(turtleModel.getAngle() + parameters.get(0));
        return parameters.get(0);
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
