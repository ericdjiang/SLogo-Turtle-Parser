package execution;

import java.util.List;
import model.TurtleModel;

public interface Command {
    double execute(List<Double> parameters, TurtleModel turtleModel);

    int getNumParams();
}
