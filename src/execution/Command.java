package execution;

import java.util.List;
import model.TurtleModel;

public interface Command {
    double execute(List<String> parameters, TurtleModel turtleModel);

    int getNumParams();
}
