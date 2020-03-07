package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;
import java.util.Map;

public class SetPenColor implements Command {
    private static final int FIRST = 0;
    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModel TurtleModel) {
        double index = Double.parseDouble(parameters.get(FIRST));
        TurtleModel.setPenColor(PaletteModel.getColor(index));
        return index;
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
