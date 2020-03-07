package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;
import java.util.Map;

public class SetPalette implements Command {
    private static final int FIRST = 0;
    private static final int SECOND = 1;
    private static final int THIRD = 2;
    private static final int FOURTH = 3;

    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModel TurtleModel) {
        double index =  Double.parseDouble(parameters.get(FIRST));
        double r = Double.parseDouble(parameters.get(SECOND));
        double g =  Double.parseDouble(parameters.get(THIRD));
        double b = Double.parseDouble(parameters.get(FOURTH));
        PaletteModel.addColor(index, r, g, b);
        return index;
    }

    @Override
    public int getNumParams() {
        return 4;
    }
}
