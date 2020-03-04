package execution.all_commands;

import execution.Command;

import model.*;

import java.util.List;
import java.util.Map;

public class SetHeading implements Command {

    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModelContainer turtleModelContainer) {
        for (TurtleModel turtleModel: turtleModelContainer.getActiveTurtles()){
            turtleModel.setAngle(Double.parseDouble(parameters.get(0)));
        }

        consoleModel.setReturnVal(Double.parseDouble(parameters.get(0)));
        return Double.parseDouble(parameters.get(0));
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
