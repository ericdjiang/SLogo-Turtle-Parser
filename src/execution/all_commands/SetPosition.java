package execution.all_commands;

import execution.Command;
import model.ConsoleModel;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class SetPosition implements Command {
    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel, ConsoleModel consoleModel) {
        double orginalX = turtleModel.getX();
        double orginalY = turtleModel.getY();
        double newX = Double.parseDouble(parameters.get(0));
        double newY = Double.parseDouble(parameters.get(1));
        turtleModel.setXY(newX, newY);
        double distanceTraveled = Math.sqrt(Math.pow(newX - orginalX,2) + Math.pow(newY - orginalY,2));
        consoleModel.setReturnVal(distanceTraveled);
        return distanceTraveled;
    }

    @Override
    public int getNumParams() {
        return 2;
    }
}
