package controller;

import model.TurtleModel;
import view.Pen;
import view.TurtleView;
import view.TurtleWindow;

public class Controller {
    private TurtleModel turtleModel;
    private TurtleWindow turtleWindow;
    private TurtleView turtleView;
    private Pen pen;

    public Controller(TurtleModel turtleBackEnd, TurtleWindow turtleFrontEnd) {
        this.turtleModel = turtleBackEnd;
        this.turtleWindow = turtleFrontEnd;
        this.turtleView = new TurtleView();
        this.pen = new Pen();
        turtleView.setTurtleXPos(turtleModel.getX());
        turtleView.setTurtleYPos(turtleModel.getY());
        turtleWindow.getChildren().add(pen);
        turtleWindow.getChildren().add(turtleView);
    }
    public void update() {
        turtleView.setTurtleXPos(turtleModel.getX());
        turtleView.setTurtleYPos(turtleModel.getY());
        turtleView.setTurtleRotation(turtleModel.getAngle());
        pen.addPoint(turtleModel.getX() + turtleView.getWidth()/2, turtleModel.getY() + turtleView.getHeight()/2);
        pen.draw();
    }
    public TurtleModel getModel() {
        return this.turtleModel;
    }
    public TurtleView getView() {
        return this.turtleView;
    }
    public Pen getPen() {
        return this.pen;
    }

}
