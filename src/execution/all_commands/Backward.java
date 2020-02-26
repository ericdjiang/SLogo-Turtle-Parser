package execution.all_commands;

import execution.Command;
import java.util.List;
import model.TurtleModel;
import model.VariableModel;

public class Backward implements Command {
    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel) {
        System.out.println("Moving backwards by: "+ parameters.get(0));
        double distance = Double.parseDouble(parameters.get(0));
        double radians = turtleModel.getAngle() * Math.PI/180;
        double xChange = distance * Math.sin(radians);
        double yChange = distance * Math.cos(radians);
        turtleModel.setX(turtleModel.getX() - xChange);
        turtleModel.setY(turtleModel.getY() + yChange);
        return distance;
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
