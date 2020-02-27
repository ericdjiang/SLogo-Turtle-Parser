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
        double distance = Math.sqrt(Math.pow(2,originalX) + Math.pow(2, originalY));
        turtleModel.setCleared(true);
        consoleModel.setReturnVal(distance);
        return distance;
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
