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
        turtleView.setTurtleXPos(turtleModel.getX());
        turtleView.setTurtleYPos(turtleModel.getY());
        this.pen = new Pen();
        turtleWindow.getChildren().add(pen);
        turtleWindow.getChildren().add(turtleView);
        System.out.println(turtleModel.getX());
        System.out.println(turtleModel.getY());
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

}
