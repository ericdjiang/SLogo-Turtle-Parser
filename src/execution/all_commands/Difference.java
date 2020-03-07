package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;

public class Difference implements Command {
    private static final int FIRST = 0;
    private static final int SECOND = 1;

    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, ModelContainer allModels) {
        ConsoleModel console = allModels.getConsoleModel();
        double difference = Double.parseDouble(parameters.get(FIRST)) - Double.parseDouble(parameters.get(SECOND));
        console.setReturnVal(difference);
        return difference;
    }

    @Override
    public int getNumParams() {
        return 2;
    }
}
