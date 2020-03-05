package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;
import java.util.Map;

public class Home implements Command {
    private static final int CENTER = 0;
    private static final int SQUARED = 2;
    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModelContainer turtleModelContainer, TurtleModel turtleModel){
            double originalX = turtleModel.getX();
            double originalY = turtleModel.getY();
            turtleModel.setXY(CENTER,CENTER);
            double distance = Math.sqrt(Math.pow(originalX,SQUARED) + Math.pow( originalY,SQUARED));
            consoleModel.setReturnVal(distance);
        return distance;
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
