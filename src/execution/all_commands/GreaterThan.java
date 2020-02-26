package execution.all_commands;

import execution.Command;
import java.util.List;
import model.TurtleModel;

public class GreaterThan implements Command {

    @Override
    public double execute(List<Double> parameters, TurtleModel turtleModel) {
        if(parameters.get(1) > parameters.get(0)) return 1;
        return 0;
    }

    @Override
    public int getNumParams() {
        return 2;
    }
}
