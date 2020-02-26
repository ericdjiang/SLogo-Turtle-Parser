package execution.all_commands;

import execution.Command;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class MakeVariable implements Command {
    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel) {
        variableModel.updateVariable(parameters.get(0), Double.parseDouble(parameters.get(1)));
        System.out.println(variableModel.getValue(parameters.get(0)));
        return (variableModel.getValue(parameters.get(0)));
    }

    @Override
    public int getNumParams() {
        return 2;
    }
}
