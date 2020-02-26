package execution.turtle_commands;

import execution.Command;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class SetPosition implements Command {
    @Override
    public double execute(List<Double> parameters, TurtleModel turtleModel, VariableModel variableModel) {
        double currentX = turtleModel.getX();
        double currentY = turtleModel.getY();
        double distanceTraveled = Math.sqrt(Math.pow(2,currentX - parameters.get(0)) + Math.pow(2, currentY - parameters.get(1) ));
        turtleModel.setXY(parameters.get(0), parameters.get(1));
        return distanceTraveled;
    }

    @Override
    public int getNumParams() {
        return 2;
    }
}
