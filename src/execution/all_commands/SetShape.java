package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;

public class SetShape implements Command {
    private static final int FIRST = 0;
    @Override
    public double execute(List<String> parameters, TurtleModel TurtleModel, ModelContainer allModels) {
        return Double.parseDouble(parameters.get(FIRST));
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
