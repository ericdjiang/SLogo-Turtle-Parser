package execution.all_commands;

import execution.Command;
import model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Tell implements Command {
    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModelContainer turtleModelContainer) {
        List <String> symbolList = Arrays.asList(parameters.get(0).split("[ ]+"));
        List<TurtleModel> newActiveTurtles = new ArrayList<>();
        for(int i = 2; i < symbolList.size(); i ++){
            int id = Integer.parseInt(symbolList.get(i));
            if(!turtleModelContainer.getTurtleIds().contains(id)){
                TurtleModel turtleModel = turtleModelContainer.addToTurtleModels(id);
                newActiveTurtles.add(turtleModel);
            }
                else{
                    TurtleModel turtleModel = turtleModelContainer.getTurleModel(id);
                    newActiveTurtles.add(turtleModel);
            }
        }
        turtleModelContainer.setActiveTurtles(newActiveTurtles);
        return 1;
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
