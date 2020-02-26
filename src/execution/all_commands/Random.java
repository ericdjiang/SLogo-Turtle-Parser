package execution.all_commands;

import execution.Command;
import model.ConsoleModel;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class Random implements Command {

    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel, ConsoleModel consoleModel) {
        double randomnum = Math.random() * Double.parseDouble(parameters.get(0)) + 1;
        System.out.println("Inside Random Class: Ramdom number is " + (int) randomnum + ": param is " + parameters.get(0));
        return randomnum;
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
