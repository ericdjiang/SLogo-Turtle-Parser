package execution.all_commands;

import execution.Command;
import model.ConsoleModel;
import model.MethodModel;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;
import java.util.Map;

public class Pi implements Command {

    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels) {

        System.out.println(Math.PI);
        consoleModel.setReturnVal(Math.PI);
        return Math.PI;
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
