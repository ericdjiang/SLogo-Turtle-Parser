package execution;

import model.*;

import java.util.List;
import java.util.Map;

public interface MultipleTurtlesCommand {
    double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModelContainer turtleModelContainer, TurtleModel currentTurtleModel);

    int getNumParams();
}
