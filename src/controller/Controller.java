package controller;

import model.ConsoleModel;
import model.TurtleModel;
import view.Pen;
import view.TurtleView;
import view.TurtleWindow;

public class Controller {
    private TurtleModel turtleModel;
    private TurtleWindow turtleWindow;
    private TurtleView turtleView;
    private ConsoleModel consoleModel;
    private Pen pen;

    public Controller(TurtleModel turtleBackEnd, TurtleWindow turtleFrontEnd, ConsoleModel consoleModel) {
        this.turtleModel = turtleBackEnd;
        this.turtleWindow = turtleFrontEnd;
        this.turtleView = new TurtleView();
        this.consoleModel = consoleModel;
        this.pen = new Pen();
        turtleView.setX(turtleModel.getX());
        turtleView.setY(turtleModel.getY());
        turtleWindow.getChildren().add(turtleView);
    }
    public void update() {
        pen.addPoint(turtleView.getX() + turtleView.getWidth()/2, turtleView.getY() + turtleView.getHeight()/2, turtleModel.getX() + turtleView.getWidth()/2, turtleModel.getY() + turtleView.getHeight()/2);
        turtleWindow.getChildren().add(pen.draw(pen.getColor()));
        turtleView.setX(turtleModel.getX());
        turtleView.setY(turtleModel.getY());
        turtleView.setTurtleRotation(turtleModel.getAngle());
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
    public ConsoleModel getConsoleModel() { return this.consoleModel; }
}
