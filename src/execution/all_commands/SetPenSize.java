package execution.all_commands;

import execution.Command;
import model.*;

import java.util.List;

public class SetPenSize implements Command {
    private static final int FIRST = 0;
    @Override
    public double execute(List<String> parameters, TurtleModel TurtleModel, ModelContainer allModels) {
        double penSize = Double.parseDouble(parameters.get(FIRST));
        TurtleModel.setPenSize(penSize);
        return penSize;
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
