package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;
import java.util.Map;

public class GetPenColor implements Command {
    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModel TurtleModel) {
        List<Double> rgbVals = TurtleModel.getPenColor();
        Double index = PaletteModel.getIndex(rgbVals);
        return 0;
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
