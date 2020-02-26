package execution.all_commands;

import execution.Command;
import java.util.List;
import model.TurtleModel;

public class SetHeading implements Command {

    @Override
    public double execute(List<Double> parameters, TurtleModel turtleModel) {
        System.out.println("turns turtle to an absolute heading by " +parameters.get(0) + " degrees");
        return parameters.get(0);
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
