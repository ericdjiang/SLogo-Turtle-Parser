package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;
import java.util.Map;

public class ShowTurtle implements Command {
    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModelContainer turtleModelContainer, TurtleModel turtleModel) {

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
