package execution.all_commands;

import execution.Command;
import java.util.List;
import java.util.Map;

import model.*;

public class Right implements Command {
    private static final int FIRST = 0;
    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModel turtleModel) {
           turtleModel.setAngle(turtleModel.getAngle() + Double.parseDouble(parameters.get(FIRST)));


        consoleModel.setReturnVal(Double.parseDouble(parameters.get(FIRST)));
        return Double.parseDouble(parameters.get(FIRST));
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
