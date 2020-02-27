package execution.all_commands;

import execution.Command;
import model.ConsoleModel;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class ShowTurtle implements Command {
    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel, ConsoleModel consoleModel) {
        turtleModel.showTurtle();
        System.out.println("Showing Turtle");
        consoleModel.setReturnVal(1);
        return 1;
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
