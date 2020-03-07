package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;

public class Turtles implements Command {
    @Override
    public double execute(List<String> parameters, TurtleModel TurtleModel, ModelContainer allModels){
        double num = allModels.getTurtleModelContainer().getTurtleModels().size();
        ConsoleModel consoleModel = allModels.getConsoleModel();
        consoleModel.setReturnVal(num);
        return num;
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
