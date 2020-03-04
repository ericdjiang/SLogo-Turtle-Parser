package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;
import java.util.Map;

public class Home implements Command {
    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModelContainer turtleModelContainer, TurtleModel currentTurtleModel){
        double distance = 0;
        TurtleModel turtleModel = currentTurtleModel;
            double originalX = turtleModel.getX();
            double originalY = turtleModel.getY();
            turtleModel.setXY(0,0);
            distance = Math.sqrt(Math.pow(originalX,2) + Math.pow( originalY,2));
            System.out.println(distance);


        consoleModel.setReturnVal(distance);
        return distance;
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
