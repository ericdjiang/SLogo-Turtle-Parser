package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;
import java.util.Map;

public class Tangent implements Command {
    private static final int FIRST = 0;
    private static final int SECOND = 1;
    private static final int HALFCIRCLE = 180;

    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModel turtleModel) {
        System.out.println("Tangent of " + parameters.get(FIRST));

        consoleModel.setReturnVal(Math.tan((Double.parseDouble(parameters.get(FIRST))*Math.PI)/HALFCIRCLE));
        return Math.tan((Double.parseDouble(parameters.get(FIRST))*Math.PI)/HALFCIRCLE);
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
