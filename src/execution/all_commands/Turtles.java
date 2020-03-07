package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;

public class Turtles implements Command {
    @Override
    public double execute(List<String> parameters, TurtleModel TurtleModel, ModelContainer allModels){
        ConsoleModel consoleModel = allModels.getConsoleModel();
        return allModels.getTurtleModelContainer().getTurtleModels().size();
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
