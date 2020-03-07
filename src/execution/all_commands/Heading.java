package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;

public class Heading implements Command {
    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, ModelContainer allModels) {
        ConsoleModel consoleModel = allModels.getConsoleModel();
        consoleModel.setReturnVal(turtleModel.getAngle());
        return turtleModel.getAngle();
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
