package controller;

import execution.CommandFactory;
import model.TurtleModel;
import parsing.Parser;
import view.TurtleView;

public class Controller {
    private TurtleModel turtleModel;
    private TurtleView turtleView;

    public Controller(TurtleModel turtleBackEnd, TurtleView turtleFrontEnd) {
        this.turtleModel = turtleBackEnd;
        this.turtleView = turtleFrontEnd;
    }

    public void update() {
        turtleView.setTurtleXPos(turtleModel.getX());
        turtleView.setTurtleYPos(turtleModel.getY());
    }
    public TurtleModel getModel() {
        return this.turtleModel;
    }

}
