package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;
import java.util.Map;

public class Random implements Command {
    private static final int FIRST = 0;

    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModelContainer turtleModelContainer, TurtleModel turtleModel) {
        double randomnum = Math.random() * Double.parseDouble(parameters.get(FIRST)) + 1;
        System.out.println("Inside Random Class: Ramdom number is " + (int) randomnum + ": param is " + parameters.get(FIRST));
        consoleModel.setReturnVal(randomnum);
        return randomnum;
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
