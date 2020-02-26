package execution.turtle_commands;

import execution.Command;
import java.util.List;

import model.ConsoleModel;
import model.TurtleModel;

public class Backward implements Command {
    @Override
    public double execute(List<Double> parameters, TurtleModel turtleModel, ConsoleModel consoleModel) {
        System.out.println("Moving backwards by: "+ parameters.get(0));
        double radians = turtleModel.getAngle() * Math.PI/180;
        double xChange = parameters.get(0) * Math.sin(radians);
        double yChange = parameters.get(0) * Math.cos(radians);
        turtleModel.setX(turtleModel.getX() - xChange);
        turtleModel.setY(turtleModel.getY() + yChange);
        turtleModel.setAngle(radians);
        return parameters.get(0);
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
