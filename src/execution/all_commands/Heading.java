package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;
import java.util.Map;

public class Heading implements Command {
    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModelContainer turtleModelContainer, TurtleModel currentTurtleModel) {
        consoleModel.setReturnVal(currentTurtleModel.getAngle());
        return currentTurtleModel.getAngle();
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
