package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;
import java.util.Map;

public class SetPosition implements Command {
    private static final int FIRST = 0;
    private static final int SECOND = 1;
    private static final int SQUARED = 2;
    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModelContainer turtleModelContainer, TurtleModel turtleModel) {
            double orginalX = turtleModel.getX();
            double orginalY = turtleModel.getY();
            double newX = Double.parseDouble(parameters.get(FIRST));
            double newY = Double.parseDouble(parameters.get(SECOND));
            turtleModel.setXY(newX, newY);
            double distanceTraveled = Math.sqrt(Math.pow(newX - orginalX,SQUARED) + Math.pow(newY - orginalY,SQUARED));


        consoleModel.setReturnVal(distanceTraveled);
        return distanceTraveled;
    }

    @Override
    public int getNumParams() {
        return 2;
    }
}
