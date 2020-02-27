package execution.all_commands;

import execution.Command;
import model.ConsoleModel;
import model.MethodModel;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;
import java.util.Map;

public class Tangent implements Command {

    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels) {
        System.out.println("Tangent of " + parameters.get(0));
        consoleModel.setReturnVal(Math.tan((Double.parseDouble(parameters.get(0))*Math.PI)/180));
        return Math.tan((Double.parseDouble(parameters.get(0))*Math.PI)/180);
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
