package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;
import java.util.Map;

public class ClearScreen implements Command {
    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModelContainer turtleModelContainer, TurtleModel currentTurtleModel) {
        double distance = 0;
      TurtleModel turtleModel = currentTurtleModel;
            double originalX = turtleModel.getX();
            double originalY = turtleModel.getY();
            distance = Math.sqrt(Math.pow(originalX,2) + Math.pow(originalY,2));
            turtleModel.setX(0);
            turtleModel.setY(0);
            turtleModel.setAngle(0);
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
