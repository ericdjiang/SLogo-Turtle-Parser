package execution;

import java.util.List;

import model.ConsoleModel;
import model.TurtleModel;
import model.VariableModel;

public interface Command {
    double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel, ConsoleModel consoleModel);


    int getNumParams();
}
