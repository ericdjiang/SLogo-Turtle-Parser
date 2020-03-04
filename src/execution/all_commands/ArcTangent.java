package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;
import java.util.Map;

public class ArcTangent implements Command {

    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModelContainer turtleModelContainer) {
        double angle = Double.parseDouble(parameters.get(0));
        System.out.println("Arctangent of " + parameters.get(0));
        consoleModel.setReturnVal(Math.atan((angle*Math.PI)/180));
        return Math.atan((angle*Math.PI)/180);
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
