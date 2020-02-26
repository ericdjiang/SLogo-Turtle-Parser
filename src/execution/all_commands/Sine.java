package execution.all_commands;

import execution.Command;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class Sine implements Command {
    @Override
    public double execute(List<Double> parameters, TurtleModel turtleModel, VariableModel variableModel) {
        System.out.println("Sine of " + parameters.get(0));
        return Math.sin((parameters.get(0)*Math.PI)/180);
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
