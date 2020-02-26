package execution.all_commands;

import execution.Command;
import java.util.List;
import model.TurtleModel;

public class Sum implements Command {
    @Override
    public double execute(List<Double> parameters, TurtleModel turtleModel) {
        double sum = parameters.get(0) + parameters.get(1);
        return sum;
    }

    @Override
    public int getNumParams() {
        return 2;
    }
}
