package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;
import java.util.Map;

public class Sine implements Command {
    private static final int FIRST = 0;
    private static final int SECOND = 1;
    private static final int HALFCIRCLE = 180;
    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModel turtleModel) {
        double angle = Double.parseDouble(parameters.get(FIRST));
        double sine = Math.sin(Math.toRadians(angle));
        System.out.println("Sine of " + parameters.get(FIRST));
        consoleModel.setReturnVal(sine);
        return sine;
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
