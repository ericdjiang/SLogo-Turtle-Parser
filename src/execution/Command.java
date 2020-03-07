package execution;

import java.util.List;

import model.*;

public interface Command {
    double execute(List<String> parameters, TurtleModel TurtleModel, ModelContainer allModels);
    int getNumParams();
}
