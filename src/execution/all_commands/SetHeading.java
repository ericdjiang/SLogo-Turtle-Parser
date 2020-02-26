package execution.all_commands;

import execution.Command;
import java.util.List;
import model.TurtleModel;
import model.VariableModel;

public class SetHeading implements Command {

    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel) {
        System.out.println("turns turtle to an absolute heading by " +parameters.get(0) + " degrees");
        turtleModel.setAngle(Double.parseDouble(parameters.get(0)));
        return Double.parseDouble(parameters.get(0));
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
