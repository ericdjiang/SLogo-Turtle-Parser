package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;

public class Pi implements Command {

    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, ModelContainer allModels) {
        ConsoleModel consoleModel = allModels.getConsoleModel();
        consoleModel.setReturnVal(Math.PI);
        return Math.PI;
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
