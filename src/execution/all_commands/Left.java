package execution.all_commands;

import execution.Command;
import java.util.List;
import java.util.Map;

import model.*;

public class Left implements Command {
    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModelContainer turtleModelContainer) {
        double angle = Double.parseDouble(parameters.get(0));
        for (TurtleModel turtleModel: turtleModelContainer.getActiveTurtles()){
            turtleModel.setAngle(turtleModel.getAngle() - Double.parseDouble(parameters.get(0)));

        }

        consoleModel.setReturnVal(Double.parseDouble(parameters.get(0)));
        return angle ;
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
