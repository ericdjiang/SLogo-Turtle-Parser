package execution.all_commands;

import execution.Command;
import java.util.List;
import model.TurtleModel;

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
