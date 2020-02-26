package execution.turtle_commands;

import execution.Command;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class XCoordinate implements Command {
    @Override
    public double execute(List<Double> parameters, TurtleModel turtleModel, VariableModel variableModel) {
        System.out.println("Getting x location of turtle");
        return turtleModel.getX();
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
