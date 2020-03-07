package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;

public class GetPenColor implements Command {
    @Override
    public double execute(List<String> parameters, TurtleModel TurtleModel, ModelContainer allModels) {
        ConsoleModel consoleModel = allModels.getConsoleModel();
        PaletteModel palette = allModels.getPaletteModel();
        List<Integer> rgbVals = TurtleModel.getPenColor();
        Double index = palette.getIndex(rgbVals);
        consoleModel.setReturnVal(index);
        return index;
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
