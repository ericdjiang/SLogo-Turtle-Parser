package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;

public class ClearScreen implements Command {
    private final static int CENTER = 0;
    private final static int SQUARED = 2;
    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, ModelContainer allModels) {
        ConsoleModel consoleModel = allModels.getConsoleModel();
        double originalX = turtleModel.getX();
        double originalY = turtleModel.getY();
        double distance = Math.sqrt(Math.pow(originalX,SQUARED) + Math.pow(originalY,SQUARED));
        turtleModel.setX(CENTER);
        turtleModel.setY(CENTER);
        turtleModel.setAngle(CENTER);
        turtleModel.setCleared(true);
        turtleModel.reInitCenter();
        consoleModel.setReturnVal(distance);
        return distance;
    }


    @Override
    public int getNumParams() {
        return 0;
    }
}
