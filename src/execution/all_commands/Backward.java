package execution.all_commands;

import execution.Command;
import java.util.List;

import model.ConsoleModel;
import model.TurtleModel;
import model.VariableModel;

public class Backward implements Command {
    @Override

    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel, ConsoleModel consoleModel) {
        System.out.println("Moving backwards by: "+ parameters.get(0));
        double distance = Double.parseDouble(parameters.get(0));
        double oppositeangle = turtleModel.getAngle() + 180;
        System.out.println(oppositeangle);
        System.out.println(turtleModel.getAngle());
        double radians = oppositeangle * (Math.PI/180);
        double xChange = distance * Math.sin(radians);
        double yChange = -1 * distance * Math.cos(radians);
        System.out.println(xChange);
        System.out.println(yChange);
        turtleModel.setX(turtleModel.getX() + xChange);
        turtleModel.setY(turtleModel.getY() + yChange);
        return distance;
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
