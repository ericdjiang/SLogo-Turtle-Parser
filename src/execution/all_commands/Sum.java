package execution.all_commands;

import execution.Command;
import model.ConsoleModel;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class Sum implements Command {

    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel, ConsoleModel consoleModel) {
        double sum = Double.parseDouble(parameters.get(0)) + Double.parseDouble(parameters.get(1));
        System.out.println(sum);
        consoleModel.setReturnVal(sum);
        return sum;
    }


    @Override
    public int getNumParams() {
        return 2;
    }
}
