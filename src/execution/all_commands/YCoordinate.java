package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;

public class YCoordinate implements Command {
    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, ModelContainer allModels) {
        ConsoleModel consoleModel = allModels.getConsoleModel();
        double y = turtleModel.getY();
        consoleModel.setReturnVal(y);
        return y;
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
