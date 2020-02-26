package execution.all_commands;

import execution.Command;
import model.ConsoleModel;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class NaturalLog implements Command {

    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel, ConsoleModel consoleModel) {
        System.out.println("Natural Log of" + parameters.get(0));
        return Math.log(Double.parseDouble(parameters.get(0)));
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
