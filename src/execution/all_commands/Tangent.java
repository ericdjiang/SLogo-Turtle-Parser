package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;

public class Tangent implements Command {
    private static final int FIRST = 0;
    private static final int HALFCIRCLE = 180;

    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, ModelContainer allModels) {
        ConsoleModel consoleModel = allModels.getConsoleModel();
        double angle = Double.parseDouble(parameters.get(0));
        double tangent = Math.tan(Math.toRadians(angle));
        System.out.println("Tangent of " + parameters.get(FIRST));
        consoleModel.setReturnVal(tangent);
        return tangent;
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
