package execution.all_commands;

import execution.Command;
import model.ConsoleModel;
import model.TurtleModel;

import java.io.Console;
import java.util.List;
import model.TurtleModel;
import model.VariableModel;

public class Equal implements Command {
    @Override

    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel, ConsoleModel consoleModel) {
        if(parameters.get(0).equals(parameters.get(1))){
            return 1;
        }
        return 0;
    }

    @Override
    public int getNumParams() {
        return 2;
    }
}
