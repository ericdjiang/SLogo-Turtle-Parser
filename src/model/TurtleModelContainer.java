package model;

import java.util.ArrayList;
import java.util.List;

public class TurtleModelContainer {

    private List<TurtleModel> activeTurtles;
    private List<TurtleModel> turtleModels;
    private List<Integer>     turtleIds;

    public TurtleModelContainer(){
        activeTurtles = new ArrayList<>();
        turtleModels = new ArrayList<>();
        turtleIds = new ArrayList<>();
    }

    public List<TurtleModel> getActiveTurtles(){
        return activeTurtles;
    }

    public List<TurtleModel> getTurtleModels(){
        return turtleModels;
    }

    public void makeTurtleActive(int id){
        TurtleModel turtleModel = turtleModels.get(id);
        activeTurtles.add(turtleModel);
    }

    public void makeTurtleInactive(int id){
        TurtleModel turtleModel = turtleModels.get(id);
        activeTurtles.remove(turtleModel);
    }

    public TurtleModel addToTurtleModels(int id){
        TurtleModel turtleModel = new TurtleModel(id,0,0,0);
        turtleModels.add(turtleModel);
        turtleIds.add(id);
        return turtleModel;
    }

    public void setActiveTurtles(List<TurtleModel> activeturtles){
        activeTurtles = activeturtles;
    }
    public List<Integer> getTurtleIds(){
        return turtleIds;
    }
    public TurtleModel getTurleModel(int id){
        for(TurtleModel turtleModel: turtleModels){
            if(id == turtleModel.getModelId()){
                return turtleModel;
            }
        }
        return null;
    }
}
