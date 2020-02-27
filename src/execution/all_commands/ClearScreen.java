package execution.all_commands;

import execution.Command;
import model.ConsoleModel;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class ClearScreen implements Command {
    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel, ConsoleModel consoleModel) {
        double originalX = turtleModel.getX();
        double originalY = turtleModel.getY();
        double distance = Math.sqrt(Math.pow(originalX,2) + Math.pow(originalY,2));
        turtleModel.setX(0);
        turtleModel.setY(0);
        turtleModel.setAngle(0);
        turtleModel.setCleared(true);
        turtleModel.setX(0);
        turtleModel.setY(0);
        turtleModel.setAngle(0);
        consoleModel.setReturnVal(distance);
        return distance;
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
