package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;

public class HideTurtle implements Command {
    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, ModelContainer allModels) {
        ConsoleModel consoleModel = allModels.getConsoleModel();
        turtleModel.hideTurtle();
        consoleModel.setReturnVal(0);
        return 0;
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
