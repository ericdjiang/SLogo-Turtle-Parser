package execution.all_commands;

import execution.Command;
import java.util.List;

import model.ConsoleModel;
import model.TurtleModel;
import model.VariableModel;

public class Right implements Command {
    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel, ConsoleModel consoleModel) {
        System.out.println("Rotating Right by: "+ parameters.get(0));
        turtleModel.setAngle(turtleModel.getAngle() + Double.parseDouble(parameters.get(0)));
        return Double.parseDouble(parameters.get(0));
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
