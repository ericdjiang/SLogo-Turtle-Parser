package execution.all_commands;

import execution.Command;
import java.util.List;
import java.util.Map;

import model.*;

public class Forward implements Command {
    private static final int FIRST = 0;
    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModel turtleModel) {
        System.out.println("inside forward" + parameters.get(0));
        double radians = Math.toRadians(turtleModel.getAngle());
        double distance = Double.parseDouble(parameters.get(FIRST));
        double xChange = Double.parseDouble(parameters.get(FIRST)) * Math.sin(radians);
        double yChange =  Double.parseDouble(parameters.get(FIRST)) * Math.cos(radians);
        turtleModel.setX(turtleModel.getX() + xChange);
        turtleModel.setY(turtleModel.getY() + yChange);
        consoleModel.setReturnVal(Double.parseDouble(parameters.get(FIRST)));
        return distance;
    }

    @Override
    public int getNumParams() {
        return 1;
    }

}
