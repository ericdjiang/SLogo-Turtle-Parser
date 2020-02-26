package execution;

import java.util.List;
import model.TurtleModel;
import model.VariableModel;

public interface Command {
    double execute(List<Double> parameters, TurtleModel turtleModel, VariableModel variableModel);

    int getNumParams();
}
