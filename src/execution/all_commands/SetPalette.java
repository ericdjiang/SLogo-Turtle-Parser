package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;

public class SetPalette implements Command {
    private static final int FIRST = 0;
    private static final int SECOND = 1;
    private static final int THIRD = 2;
    private static final int FOURTH = 3;

    @Override
    public double execute(List<String> parameters, TurtleModel TurtleModel, ModelContainer allModels) {
        PaletteModel paletteModel = allModels.getPaletteModel();
        double index =  Double.parseDouble(parameters.get(FIRST));
        double r = Double.parseDouble(parameters.get(SECOND));
        double g =  Double.parseDouble(parameters.get(THIRD));
        double b = Double.parseDouble(parameters.get(FOURTH));
        paletteModel.addColor(index, r, g, b);
        return index;
    }

    @Override
    public int getNumParams() {
        return 4;
    }
}
