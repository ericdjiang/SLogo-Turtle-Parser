package execution.all_commands;

import execution.Command;
import java.util.List;
import java.util.Map;

import model.ConsoleModel;
import model.MethodModel;
import model.TurtleModel;
import model.VariableModel;

public class Left implements Command {
    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels) {
        System.out.println("Rotating Left by: "+ parameters.get(0));
        turtleModel.setAngle(turtleModel.getAngle() - Double.parseDouble(parameters.get(0)));
        consoleModel.setReturnVal(Double.parseDouble(parameters.get(0)));
        return Double.parseDouble(parameters.get(0)) ;
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
