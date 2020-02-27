package execution.all_commands;

import execution.Command;
import model.ConsoleModel;
import model.MethodModel;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;
import java.util.Map;

public class Home implements Command {
    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels){
        double originalX = turtleModel.getX();
        double originalY = turtleModel.getY();
        turtleModel.setXY(0,0);
        double distance = Math.sqrt(Math.pow(originalX,2) + Math.pow( originalY,2));
        System.out.println(distance);
        consoleModel.setReturnVal(distance);
        return distance;
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
