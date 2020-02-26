package execution.all_commands;

import execution.Command;
import java.util.List;
import model.TurtleModel;

public class Equal implements Command {
    @Override
    public double execute(List<Double> parameters, TurtleModel turtleModel) {
        if(parameters.get(0) == parameters.get(1)){
            System.out.println(1);
            return 1;
        }
        System.out.println(0);
        return 0;
    }

    @Override
    public int getNumParams() {
        return 2;
    }
}
