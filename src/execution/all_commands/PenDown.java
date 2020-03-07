package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;

public class PenDown implements Command {
    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, ModelContainer allModels) {
        ConsoleModel consoleModel = allModels.getConsoleModel();
        turtleModel.makePenDown();
        System.out.println("inside pen down");
        consoleModel.setReturnVal(1);
        return 1;
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
