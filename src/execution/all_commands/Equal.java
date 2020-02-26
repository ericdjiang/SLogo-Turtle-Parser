package execution.all_commands;

import execution.Command;
import java.util.List;
import model.TurtleModel;
import model.VariableModel;

public class Equal implements Command {
    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel) {
        if(parameters.get(0).equals(parameters.get(1))){
            System.out.println(1);
            return 1;
        }
        System.out.println(0);
        return 0;
    }

    @Override
    public int getNumParams() {
        return 2;
    }
}
