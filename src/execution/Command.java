package execution;

import java.util.List;
import java.util.Map;

import model.*;

public interface Command {
    double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModel TurtleModel);


    int getNumParams();
}
