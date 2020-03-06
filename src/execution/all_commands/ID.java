package execution.all_commands;

import execution.Command;

import javafx.scene.web.HTMLEditorSkin;
import model.ConsoleModel;
import model.MethodModel;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;
import java.util.Map;

public class ID implements Command {
    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModel TurtleModel) {
        return TurtleModel.getModelId();
    }
    @Override
    public int getNumParams() {
        return 0;
    }
}
