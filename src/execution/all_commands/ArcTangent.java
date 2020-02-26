package execution.all_commands;

import execution.Command;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class ArcTangent implements Command {

    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel) {
        double angle = Double.parseDouble(parameters.get(0));
        System.out.println("Arctangent of " + parameters.get(0));
        return Math.atan((angle*Math.PI)/180);
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
