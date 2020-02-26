package execution.turtle_commands;

import execution.Command;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class IsShowing implements Command {
    @Override
    public double execute(List<Double> parameters, TurtleModel turtleModel, VariableModel variableModel) {
        System.out.println("Returns if turtle is showing or not");
        if(turtleModel.getShowing()){
            return 1;
        }
        return 0;
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
