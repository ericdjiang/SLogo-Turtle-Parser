package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;

public class GetPenColor implements Command {
    @Override
    public double execute(List<String> parameters, TurtleModel TurtleModel, ModelContainer allModels) {
        PaletteModel palette = allModels.getPaletteModel();
        List<Double> rgbVals = TurtleModel.getPenColor();
        Double index = palette.getIndex(rgbVals);
        return 0;
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
