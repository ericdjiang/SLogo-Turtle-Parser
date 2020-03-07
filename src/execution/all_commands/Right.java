package execution.all_commands;

import execution.Command;
import java.util.List;

import model.*;

public class Right implements Command {
    private static final int FIRST = 0;
    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, ModelContainer allModels) {
        ConsoleModel consoleModel = allModels.getConsoleModel();
        turtleModel.setAngle(turtleModel.getAngle() + Double.parseDouble(parameters.get(FIRST)));
        System.out.println("inside Right " + parameters.get(0));
        consoleModel.setReturnVal(Double.parseDouble(parameters.get(FIRST)));
        return Double.parseDouble(parameters.get(FIRST));
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
