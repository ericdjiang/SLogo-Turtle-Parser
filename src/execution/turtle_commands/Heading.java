package execution.turtle_commands;

import execution.Command;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class Heading implements Command {
    @Override
    public double execute(List<Double> parameters, TurtleModel turtleModel, VariableModel variableModel) {
        System.out.println("Getting angle facing of turtle");
        return turtleModel.getAngle();
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
