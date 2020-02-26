package execution.all_commands;

import execution.Command;
import java.util.List;
import model.TurtleModel;

public class Pi implements Command {
    @Override
    public double execute(List<Double> parameters, TurtleModel turtleModel) {
        System.out.println(Math.PI);
        return Math.PI;

    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
