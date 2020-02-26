package execution;

import java.util.List;

import model.ConsoleModel;
import model.TurtleModel;

public interface Command {
    double execute(List<Double> parameters, TurtleModel turtleModel, ConsoleModel consoleModel);

    int getNumParams();
}
