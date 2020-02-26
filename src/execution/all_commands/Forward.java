package execution.all_commands;

import execution.Command;
import java.util.List;

import model.ConsoleModel;
import model.TurtleModel;
import model.VariableModel;

public class Forward implements Command {
    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel, ConsoleModel consoleModel) {
        System.out.println("Moving forward by: "+ parameters.get(0));
        System.out.println(turtleModel.getAngle());
        double radians = Math.toRadians(turtleModel.getAngle());
        double xChange = Double.parseDouble(parameters.get(0)) * Math.sin(radians);
        System.out.println(xChange);
        double yChange = -1 *  Double.parseDouble(parameters.get(0)) * Math.cos(radians);
        System.out.println(yChange);
        turtleModel.setX(turtleModel.getX() + xChange);
        turtleModel.setY(turtleModel.getY() + yChange);
        return  Double.parseDouble(parameters.get(0));
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
