package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;
import java.util.Map;

public class YCoordinate implements Command {
    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModelContainer turtleModelContainer) {
        return turtleModelContainer.getActiveTurtles().get(turtleModelContainer.getActiveTurtles().size()-1).getY();
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
