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
        turtleView.setX(turtleModel.getX() + turtleWindow.getViewWidth()/2 - turtleView.getWidth()/2);
        turtleView.setY(turtleModel.getY() + turtleWindow.getViewHeight()/2 - turtleView.getHeight()/2);
        turtleWindow.getChildren().add(turtleView);
    }
    public void update() {
        pen.addPoint(turtleView.getX() + turtleView.getWidth()/2, turtleView.getY() + turtleView.getHeight()/2, turtleModel.getX() + turtleWindow.getViewWidth()/2 , turtleModel.getY()  + turtleWindow.getViewHeight()/2);
        turtleWindow.getChildren().add(pen.draw(pen.getColor()));
        turtleView.setX(turtleModel.getX() + turtleWindow.getViewWidth()/2 - turtleView.getWidth()/2);
        System.out.println(turtleModel.getY());
        System.out.println(turtleWindow.getViewHeight()/2);
        System.out.println(turtleView.getHeight()/2);
        turtleView.setY(turtleModel.getY() + turtleWindow.getViewHeight()/2 - turtleView.getHeight()/2);
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
