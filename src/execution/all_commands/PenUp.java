package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;
import java.util.Map;

public class PenUp implements Command {
    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModelContainer turtleModelContainer) {
        for (TurtleModel turtleModel: turtleModelContainer.getActiveTurtles()){
            turtleModel.makePenUp();
        }

        consoleModel.setReturnVal(0);
        return 0;
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
