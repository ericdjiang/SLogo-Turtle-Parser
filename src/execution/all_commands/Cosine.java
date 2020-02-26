package execution.all_commands;

import execution.Command;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class Cosine implements Command {

    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel) {
        System.out.println("Cosine of " + parameters.get(0));
        double angle = Double.parseDouble(parameters.get(0));
        return Math.cos((angle*Math.PI)/180);
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
