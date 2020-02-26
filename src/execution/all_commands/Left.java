package execution.all_commands;

import execution.Command;
import java.util.List;
import model.TurtleModel;

public class Left implements Command {
    @Override
    public double execute(List<Double> parameters, TurtleModel turtleModel) {
        System.out.println("Rotating Left by: "+ parameters.get(0));
        turtleModel.setAngle(turtleModel.getAngle() - parameters.get(0));
        return parameters.get(0) ;
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
