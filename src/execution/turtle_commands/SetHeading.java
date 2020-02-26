package execution.turtle_commands;

import execution.Command;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class SetHeading implements Command {

    @Override
    public double execute(List<Double> parameters, TurtleModel turtleModel, VariableModel variableModel) {
        System.out.println("turns turtle to an absolute heading by " +parameters.get(0) + " degrees");
        return parameters.get(0);
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
