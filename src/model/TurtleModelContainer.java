package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class TurtleModelContainer {

    private List<TurtleModel> activeTurtles;
    private List<TurtleModel> turtleModels;
    private List<Integer>     turtleIds;
    private TurtleContainer turtleContainer;

    public TurtleModelContainer(TurtleContainer turtlecontainer){
        turtleContainer = turtlecontainer;
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
        TurtleModel turtleModel = turtleModels.get(id-1);
        activeTurtles.add(turtleModel);
    }

    public void makeTurtleInactive(int id){
        TurtleModel turtleModel = turtleModels.get(id);
        activeTurtles.remove(turtleModel);
    }

    protected TurtleModel addToTurtleModels(int id){
        TurtleModel turtleModel = new TurtleModel(id,0,0,0);
        turtleModels.add(turtleModel);
        turtleIds.add(id);
        return turtleModel;
    }
    public TurtleModel addTurtle(int id){
        TurtleModel turtleModel = turtleContainer.addTurtle(id);
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
