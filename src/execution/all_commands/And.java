package execution.all_commands;

import execution.Command;
import java.util.List;
import java.util.Map;

import model.*;

public class And implements Command {

    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModelContainer turtleModelContainer) {
        double param1 = Double.parseDouble(parameters.get(0));
        double param2 = Double.parseDouble(parameters.get(1));
        if(param1!= 0 && param2 != 0){
            System.out.println(1);
            consoleModel.setReturnVal(1);
            return 1;
        }

        consoleModel.setReturnVal(0);
        return 0;
    }

    @Override
    public int getNumParams() {
        return 2;
    }
}
