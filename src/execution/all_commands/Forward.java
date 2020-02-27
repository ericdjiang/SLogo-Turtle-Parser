package execution.all_commands;

import execution.Command;
import java.util.List;
import java.util.Map;

import model.ConsoleModel;
import model.MethodModel;
import model.TurtleModel;
import model.VariableModel;

public class Forward implements Command {
    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels) {
        double radians = Math.toRadians(turtleModel.getAngle());
        System.out.println("Forward: "+ parameters.get(0));

        double xChange = Double.parseDouble(parameters.get(0)) * Math.sin(radians);
        double yChange =  Double.parseDouble(parameters.get(0)) * Math.cos(radians);
        turtleModel.setX(turtleModel.getX() + xChange);
        turtleModel.setY(turtleModel.getY() + yChange);
        consoleModel.setReturnVal(Double.parseDouble(parameters.get(0)));
        return Double.parseDouble(parameters.get(0));
    }

    @Override
    public int getNumParams() {
        return 1;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
