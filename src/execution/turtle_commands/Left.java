package execution.turtle_commands;

import execution.Command;
import model.ConsoleModel;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class Left implements Command {

    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel, ConsoleModel consoleModel) {
        System.out.println("Rotating Left by: "+ parameters.get(0));
        turtleModel.setAngle(turtleModel.getAngle() - Double.parseDouble(parameters.get(0)));
        return Double.parseDouble(parameters.get(0));
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
