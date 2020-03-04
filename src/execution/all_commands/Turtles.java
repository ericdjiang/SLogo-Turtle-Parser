package execution.all_commands;

import execution.Command;
import model.ConsoleModel;
import model.MethodModel;
import model.TurtleModelContainer;
import model.VariableModel;

import java.util.List;
import java.util.Map;

public class Turtles implements Command {
    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModelContainer turtleModelContainer) {
        return turtleModelContainer.getTurtleModels().size();
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
