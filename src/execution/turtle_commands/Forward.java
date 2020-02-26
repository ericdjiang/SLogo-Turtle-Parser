package execution.turtle_commands;

import execution.Command;
import java.util.List;
import model.TurtleModel;
import model.VariableModel;

public class Forward implements Command {

    @Override
    public double execute(List<Double> parameters, TurtleModel turtleModel, VariableModel variableModel) {
        System.out.println("Moving forward by: "+ parameters.get(0));
        double radians = turtleModel.getAngle() * Math.PI/180;
        double xChange = parameters.get(0) * Math.sin(radians);
        double yChange = parameters.get(0) * Math.cos(radians);
        turtleModel.setX(turtleModel.getX() + xChange);
        turtleModel.setY(turtleModel.getY() - yChange);
        return parameters.get(0);
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
