package execution.turtle_commands;

import execution.Command;
import java.util.List;
import model.TurtleModel;

public class Forward implements Command {
    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel) {
        System.out.println("Inside Forward::draw() method.");
        return 0;
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
