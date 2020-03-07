package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;

public class Not implements Command {
    private static final int FIRST = 0;

    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, ModelContainer allModels) {
        ConsoleModel consoleModel = allModels.getConsoleModel();
        if(Double.parseDouble(parameters.get(FIRST)) == 0){
            consoleModel.setReturnVal(1);
            return 1;
        }
        consoleModel.setReturnVal(0);
        return 0;
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
