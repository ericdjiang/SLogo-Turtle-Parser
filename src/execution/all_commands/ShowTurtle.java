package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;

public class ShowTurtle implements Command {
    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, ModelContainer allModels) {
        ConsoleModel consoleModel = allModels.getConsoleModel();
        turtleModel.showTurtle();
        System.out.println("Showing Turtle");
        consoleModel.setReturnVal(1);
        return 1;
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
