package execution.all_commands;

import execution.Command;
import model.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Cosine implements Command {
    private static final int FIRST = 0;
    private static final int HALFCIRCLE = 180;

    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, ModelContainer allModels) {
        ConsoleModel consoleModel = allModels.getConsoleModel();
        double angle = Double.parseDouble(parameters.get(FIRST));
        double cosine = Math.cos(Math.toRadians(angle));

        BigDecimal bd = new BigDecimal(Double.toString(cosine));
        bd = bd.setScale(4, RoundingMode.HALF_UP);
        cosine = bd.doubleValue();
        consoleModel.setReturnVal(cosine);
        return cosine;
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
