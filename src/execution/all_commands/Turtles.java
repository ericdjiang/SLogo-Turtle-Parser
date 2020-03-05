package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;
import java.util.Map;

public class Turtles implements Command {
    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModelContainer turtleModelContainer, TurtleModel turtleModel) {
        return turtleModelContainer.getTurtleModels().size();
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
