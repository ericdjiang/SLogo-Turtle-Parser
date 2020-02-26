package execution.boolean_operations;

import execution.Command;
import model.ConsoleModel;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class GreaterThan implements Command {

    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel, ConsoleModel consoleModel) {
        if(Double.parseDouble(parameters.get(1)) > Double.parseDouble(parameters.get(0))) {
            return 1;
        }
        return 0;
    }

    @Override
    public int getNumParams() {
        return 2;
    }
}
