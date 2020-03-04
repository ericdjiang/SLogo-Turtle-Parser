package execution.all_commands;

import execution.Command;
import java.util.List;
import java.util.Map;

import model.*;

public class Backward implements Command {
    @Override

    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModelContainer turtleModelContainer, TurtleModel currentTurtleModel) {
        double distance = Double.parseDouble(parameters.get(0));
        TurtleModel turtleModel = currentTurtleModel;
            double oppositeangle = turtleModel.getAngle() + 180;
            double radians = oppositeangle * (Math.PI/180);
            double yChange = distance * Math.cos(radians);
            double xChange = distance * Math.sin(radians);
            System.out.println(xChange);
            System.out.println(yChange);
            turtleModel.setX(turtleModel.getX() + xChange);
            turtleModel.setY(turtleModel.getY() + yChange);

        consoleModel.setReturnVal(distance);
        return distance;
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
