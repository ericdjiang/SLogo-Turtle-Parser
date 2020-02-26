package execution.turtle_commands;

import execution.Command;
import model.TurtleModel;

import java.util.List;

public class SetTowards implements Command {
    @Override
    public double execute(List<Double> parameters, TurtleModel turtleModel) {
        System.out.println("getting number of degrees turned" + parameters.get(0));
        return parameters.get(0);
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
