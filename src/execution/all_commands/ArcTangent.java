package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;
import java.util.Map;

public class ArcTangent implements Command {
    private static final int FIRST = 0;
    private static final int HALFCIRCLE = 180;

    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModelContainer turtleModelContainer, TurtleModel turtleModel) {
        double angle = Double.parseDouble(parameters.get(FIRST));
        consoleModel.setReturnVal(Math.atan((angle*Math.PI)/HALFCIRCLE));
        return Math.atan((angle*Math.PI)/HALFCIRCLE);
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
