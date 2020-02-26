package execution.turtle_commands;

import execution.Command;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class YCoordinate implements Command {
    @Override
    public double execute(List<Double> parameters, TurtleModel turtleModel, VariableModel variableModel) {
        System.out.println("Getting y location of turtle");
        return turtleModel.getY();
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
