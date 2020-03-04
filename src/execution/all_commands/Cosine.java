package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;
import java.util.Map;

public class Cosine implements Command {

    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModelContainer turtleModelContainer, TurtleModel currentTurtleModel) {
        double angle = Double.parseDouble(parameters.get(0));
        consoleModel.setReturnVal(Math.cos((angle*Math.PI)/180));
        return Math.cos((angle*Math.PI)/180);
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
