package execution.all_commands;

import execution.Command;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class Not implements Command {

    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel) {
        if(Double.parseDouble(parameters.get(0)) == 0){
            System.out.println(1);
            return 1;
        }
        System.out.println(0);
        return 0;
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
