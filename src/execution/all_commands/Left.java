package execution.all_commands;

import execution.Command;
import java.util.List;

import model.*;

public class Left implements Command {
    private static final int FIRST = 0;
    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, ModelContainer allModels) {
        ConsoleModel consoleModel = allModels.getConsoleModel();
        double angle = Double.parseDouble(parameters.get(FIRST));
        turtleModel.setAngle(turtleModel.getAngle() - Double.parseDouble(parameters.get(FIRST)));
        consoleModel.setReturnVal(Double.parseDouble(parameters.get(FIRST)));
        return angle ;
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
