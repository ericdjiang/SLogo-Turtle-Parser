package execution.turtle_commands;

import execution.Command;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class IsPenDown implements Command {
    @Override
    public double execute(List<Double> parameters, TurtleModel turtleModel, VariableModel variableModel) {
        System.out.println("Returns if pen is down or not");
        if(turtleModel.getPen()){
            return 1;
        }
        return 0;
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
