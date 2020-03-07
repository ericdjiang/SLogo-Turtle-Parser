package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;

public class ArcTangent implements Command {
    private static final int FIRST = 0;

    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, ModelContainer allModels) {
        ConsoleModel consoleModel = allModels.getConsoleModel();
        double angle = Double.parseDouble(parameters.get(FIRST));
        double arcTan = Math.atan(Math.toRadians(angle));
        consoleModel.setReturnVal(arcTan);
        return arcTan;
    }


    @Override
    public int getNumParams() {
        return 1;
    }
}
