package execution.boolean_operations;

import execution.Command;
import model.ConsoleModel;
import model.TurtleModel;

import java.util.List;

public class Equal implements Command {
    @Override
    public double execute(List<Double> parameters, TurtleModel turtleModel, ConsoleModel consoleModel) {
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
