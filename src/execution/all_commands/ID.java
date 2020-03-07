package execution.all_commands;

import execution.Command;

import model.*;

import java.util.List;

public class ID implements Command {
    @Override
    public double execute(List<String> parameters, TurtleModel TurtleModel, ModelContainer allModels) {
        return TurtleModel.getModelId();
    }

    @Override
    public int getNumParams() {
        return 0;
    }
}
