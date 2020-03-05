package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;
import java.util.Map;

public class Cosine implements Command {
    private static final int FIRST = 0;
    private static final int HALFCIRCLE = 180;

    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModel turtleModel) {
        double angle = Double.parseDouble(parameters.get(FIRST));
        consoleModel.setReturnVal(Math.cos((angle*Math.PI)/HALFCIRCLE));
        return Math.cos((angle*Math.PI)/HALFCIRCLE);
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
