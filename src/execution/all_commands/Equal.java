package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;
import java.util.Map;

public class Equal implements Command {
    @Override

    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModelContainer turtleModelContainer) {
        if(parameters.get(0).equals(parameters.get(1))){
            System.out.println(1);
            consoleModel.setReturnVal(1);
            return 1;
        }
        System.out.println(0);
        consoleModel.setReturnVal(0);
        return 0;
    }

    @Override
    public int getNumParams() {
        return 2;
    }
}
