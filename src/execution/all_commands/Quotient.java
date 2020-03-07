package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;

public class Quotient implements Command {
    private static final int FIRST = 0;
    private static final int SECOND = 1;
    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, ModelContainer allModels) {
        ConsoleModel consoleModel = allModels.getConsoleModel();
        System.out.println("Quotient of " + parameters.get(0) + "and " + parameters.get(1));
        double quotient = Double.parseDouble(parameters.get(FIRST))/Double.parseDouble(parameters.get(SECOND));
        consoleModel.setReturnVal(quotient);
        return quotient;
    }

    @Override
    public int getNumParams() {
        return 2;
    }
}
