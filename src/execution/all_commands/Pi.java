package execution.all_commands;

import execution.Command;
import model.ConsoleModel;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class Pi implements Command {

    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel, ConsoleModel consoleModel) {

        System.out.println(Math.PI);
        return Math.PI;
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
