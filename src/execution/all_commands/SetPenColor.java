package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;

public class SetPenColor implements Command {
    private static final int FIRST = 0;
    @Override
    public double execute(List<String> parameters, TurtleModel TurtleModel, ModelContainer allModels) {
        ConsoleModel consoleModel = allModels.getConsoleModel();
        PaletteModel paletteModel = allModels.getPaletteModel();
        double index = Double.parseDouble(parameters.get(FIRST));
        TurtleModel.setPenColor(paletteModel.getColor(index));
        consoleModel.setReturnVal(index);
        return index;
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
