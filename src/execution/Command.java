package execution;

import java.util.List;
import java.util.Map;

import model.ConsoleModel;
import model.TurtleModel;
import model.VariableModel;
import model.MethodModel;

public interface Command {
    double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels);


    int getNumParams();
}
