package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;

public class MakeVariable implements Command {
    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, ModelContainer allModels) {
        ConsoleModel consoleModel = allModels.getConsoleModel();
        VariableModel variableModel = allModels.getVariableModel();
        variableModel.updateVariable(parameters.get(0), Double.parseDouble(parameters.get(1)));
        consoleModel.setReturnVal(Double.parseDouble(parameters.get(1)));
        return Double.parseDouble(parameters.get(1));
    }

        @Override
        public int getNumParams() {
            return 2;
        }

    }
