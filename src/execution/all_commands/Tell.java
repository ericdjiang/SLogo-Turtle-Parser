package execution.all_commands;

import execution.Command;
import model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tell implements Command {
    @Override
    public double execute(List<String> parameters, TurtleModel TurtleModel, ModelContainer allModels){
        VariableModel variableModel = allModels.getVariableModel();
        TurtleModelContainer turtleModelContainer = allModels.getTurtleModelContainer();
        System.out.println(parameters.get(0));
        List <String> symbolList = Arrays.asList(parameters.get(0).split("[ ]+"));
        List<TurtleModel> newActiveTurtles = new ArrayList<>();
        ArrayList<Integer> ids = new ArrayList<>();

        int id = 0;
            for(int i = 2; i < symbolList.size(); i ++){

                if(symbolList.get(i).contains(":")){
                     id = (int) variableModel.getValue(symbolList.get(i));
                     ids.add(id);
                }
                else {
                     id = Integer.parseInt(symbolList.get(i));
                     ids.add(id);
                }

                int difference = id - turtleModelContainer.getTurtleIds().size();
                if(difference > 0){
                    for(int k = 0; k < difference; k ++ ){
                        int newId = turtleModelContainer.getTurtleIds().get(turtleModelContainer.getTurtleIds().size()-1) + 1;
                        TurtleModel newTurtleModel = turtleModelContainer.addToTurtleModels(newId);
                        newActiveTurtles.add(newTurtleModel);
                    }
                }
                else{
                    TurtleModel newTurtleModel = turtleModelContainer.getTurleModel(id);
                    newActiveTurtles.add(newTurtleModel);
                }
            }
            turtleModelContainer.setActiveTurtles(newActiveTurtles);
            for(TurtleModel turtleModel: turtleModelContainer.getTurtleModels()){
                if(ids.contains(turtleModel.getModelId())){
                    turtleModel.setActive();
                }
                else{
                    turtleModel.setInActive();
                }
            }
            for (TurtleModel active : newActiveTurtles){
                System.out.println("Turtle: " + active.getModelId() +" now active");
            }

        return id;
        }



    @Override
    public int getNumParams() {
        return 1;
    }
}
