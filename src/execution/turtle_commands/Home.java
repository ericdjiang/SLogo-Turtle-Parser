package execution.turtle_commands;

import execution.Command;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class Home implements Command {
    @Override
    public double execute(List<Double> parameters, TurtleModel turtleModel, VariableModel variableModel) {
        double currentX = turtleModel.getX();
        double currentY = turtleModel.getY();
        double distanceTraveled = Math.sqrt(Math.pow(2,currentX) + Math.pow(2, currentY ));
        turtleModel.setXY(0, 0);
        return distanceTraveled;
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
