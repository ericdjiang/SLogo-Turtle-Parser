package execution.all_commands;

import execution.Command;
import execution.MultipleTurtlesCommand;
import model.*;

import java.util.List;
import java.util.Map;

public class Turtles implements Command {
    @Override
    public double execute(List<String> parameters, TurtleModel TurtleModel, ModelContainer allModels){
        return allModels.getTurtleModelContainer().getTurtleModels().size();
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
