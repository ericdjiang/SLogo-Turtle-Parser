package execution.all_commands;

import execution.Command;

import model.*;

import java.util.List;

public class SetBackground implements Command {
    private static final int FIRST = 0;
    @Override
    public double execute(List<String> parameters, TurtleModel TurtleModel, ModelContainer allModels) {
        ConsoleModel consoleModel = allModels.getConsoleModel();
        PaletteModel paletteModel = allModels.getPaletteModel();
        double index = Double.parseDouble(parameters.get(FIRST));
        TurtleModel.setBackgroundColor(paletteModel.getColor(index));
        TurtleModel.setColorChanged(true);
        consoleModel.setReturnVal(index);
        return index;
    }

    @Override
    public int getNumParams(){
        return 1;
    }
}
