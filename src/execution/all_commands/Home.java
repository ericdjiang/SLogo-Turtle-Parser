package execution.all_commands;

import execution.Command;
import model.ConsoleModel;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class Home implements Command {
    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel, ConsoleModel consoleModel) {
        double originalX = turtleModel.getX();
        double originalY = turtleModel.getY();
        turtleModel.setXY(0,0);
        double distance = Math.sqrt(Math.pow(2,originalX) + Math.pow(2, originalY));
        System.out.println(distance);
        return distance;
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
