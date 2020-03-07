package execution.all_commands;

import execution.Command;
import model.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Sine implements Command {
    private static final int FIRST = 0;
    private static final int SECOND = 1;
    private static final int HALFCIRCLE = 180;
    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, ModelContainer allModels) {
        ConsoleModel consoleModel = allModels.getConsoleModel();
        double angle = Double.parseDouble(parameters.get(FIRST));
        Double sine = Math.sin(Math.toRadians(angle));
        System.out.println("Sine of " + parameters.get(FIRST));

        BigDecimal bd = new BigDecimal(Double.toString(sine));
        bd = bd.setScale(4, RoundingMode.HALF_UP);
        sine = bd.doubleValue();
        consoleModel.setReturnVal(sine);
        return sine;
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
