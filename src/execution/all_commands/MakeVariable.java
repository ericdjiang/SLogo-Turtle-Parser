package execution.all_commands;

import execution.Command;
import model.ConsoleModel;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class MakeVariable implements Command {


        @Override
        public double execute(List<String> parameters, TurtleModel turtleModel,
            VariableModel variableModel, ConsoleModel consoleModel) {
            variableModel
                .updateVariable(parameters.get(1), Double.parseDouble(parameters.get(0)));
            return Double.parseDouble(parameters.get(0));
        }

        @Override
        public int getNumParams() {
            return 2;
        }

    }
