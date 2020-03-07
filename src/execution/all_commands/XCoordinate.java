package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;

public class XCoordinate implements Command {
    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, ModelContainer allModels) {
        return turtleModel.getX();
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
