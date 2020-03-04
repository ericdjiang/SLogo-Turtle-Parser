package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;
import java.util.Map;

public class NaturalLog implements Command {

    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModelContainer turtleModelContainer, TurtleModel currentTurtleModel) {
        System.out.println("Natural Log of" + parameters.get(0));
        consoleModel.setReturnVal(Math.log(Double.parseDouble(parameters.get(0))));
        return Math.log(Double.parseDouble(parameters.get(0)));
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
