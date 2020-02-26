package execution.all_commands;

import execution.Command;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class Pi implements Command {

    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel) {
        System.out.println(Math.PI);
        return Math.PI;
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
