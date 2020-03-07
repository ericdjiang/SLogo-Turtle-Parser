package execution.all_commands;

import execution.Command;
import java.util.List;

import model.*;

public class Backward implements Command {
    private static final int FIRST = 0;
    private static final int HALFCIRCLE = 180;
    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, ModelContainer allModels) {
        ConsoleModel consoleModel = allModels.getConsoleModel();
        double distance = Double.parseDouble(parameters.get(FIRST));
        double oppositeangle = turtleModel.getAngle() + HALFCIRCLE;
        double radians = Math.toRadians(oppositeangle);
        double yChange = distance * Math.cos(radians);
        double xChange = distance * Math.sin(radians);
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
