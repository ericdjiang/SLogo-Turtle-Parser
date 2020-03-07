package model;

import view.layout.TurtleWindow;
import view.views.TurtleView;

import java.util.ArrayList;
import java.util.List;

public class TurtleContainer {
    private List<TurtleView> turtleViews;
    private TurtleWindow turtleWindow;
    private TurtleModelContainer turtleModelContainer;

    public TurtleContainer(TurtleWindow turtlewindow){
        turtleWindow = turtlewindow;
        turtleViews = new ArrayList<>();
        turtleModelContainer = new TurtleModelContainer();
    }

    public TurtleModel addTurtle(int id){
        TurtleModel turtleModel = turtleModelContainer.addToTurtleModels(id);
        TurtleView turtleView = new TurtleView(id);
        turtleViews.add(turtleView);
        turtleView.setX(turtleModel.getX() + turtleWindow.getViewWidth()/2 - turtleView.getWidth()/2);
        turtleView.setY(turtleModel.getY() + turtleWindow.getViewHeight()/2 - turtleView.getHeight()/2);
        turtleWindow.getChildren().add(turtleView);
        turtleView.setManaged(true);
        return turtleModel;
    }
    public TurtleView addTurtleView(int id){
        TurtleView turtleView = new TurtleView(id);
        turtleViews.add(turtleView);
        return turtleView;
    }

    public List<TurtleView> getTurtleViews(){
        return turtleViews;
    }
    public TurtleModelContainer getTurtleModelContainer(){
        return turtleModelContainer;
    }
    public TurtleView getTurtleView(int id){
        for(TurtleView turtleView: turtleViews){
            if(id == turtleView.getViewId()){
                return turtleView;
            }
        }
        return null;
    }

}
