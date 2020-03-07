package execution.all_commands;

import execution.Command;
import model.ConsoleModel;
import model.MethodModel;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;
import java.util.Map;

public class SetPenSize implements Command {
    private static final int FIRST = 0;
    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModel TurtleModel) {
        double penSize = Double.parseDouble(parameters.get(FIRST));
        TurtleModel.setPenSize(penSize);
        return penSize;
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
