package execution.math_operations;

import execution.Command;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class Random implements Command {

    @Override
    public double execute(List<Double> parameters, TurtleModel turtleModel, VariableModel variableModel) {
        double randomnum = Math.random() * parameters.get(0) + 1;
        System.out.println("Inside Random Class: Ramdom number is " + (int) randomnum + ": param is " + parameters.get(0));
        return randomnum;
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
