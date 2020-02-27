package execution.all_commands;

import execution.Command;
import model.ConsoleModel;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class Tangent implements Command {

    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel, ConsoleModel consoleModel) {
        System.out.println("Tangent of " + parameters.get(0));
        return Math.tan((Double.parseDouble(parameters.get(0))*Math.PI)/180);
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
