package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;

public class NaturalLog implements Command {
    private static final int FIRST = 0;


    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, ModelContainer allModels) {
        ConsoleModel consoleModel = allModels.getConsoleModel();
        double naturalLog = Math.log(Double.parseDouble(parameters.get(FIRST)));
        consoleModel.setReturnVal(naturalLog);
        return naturalLog;
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
