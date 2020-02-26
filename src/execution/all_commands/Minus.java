package execution.all_commands;

import execution.Command;
import model.ConsoleModel;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class Minus implements Command {
    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel, ConsoleModel consoleModel) {
        System.out.println("Negative of " + parameters.get(0));
        return -1*Double.parseDouble(parameters.get(0));
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
