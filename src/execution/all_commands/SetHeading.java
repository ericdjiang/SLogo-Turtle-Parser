package execution.all_commands;

import execution.Command;

import model.*;

import java.util.List;

public class SetHeading implements Command {
    private static final int FIRST = 0;

    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, ModelContainer allModels) {
        ConsoleModel consoleModel = allModels.getConsoleModel();
        turtleModel.setAngle(Double.parseDouble(parameters.get(FIRST)));
        consoleModel.setReturnVal(Double.parseDouble(parameters.get(FIRST)));
        return Double.parseDouble(parameters.get(FIRST));
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
