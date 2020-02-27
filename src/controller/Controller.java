package controller;

import model.ConsoleModel;
import model.TurtleModel;
import view.Pen;
import view.TurtleView;
import view.TurtleWindow;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private TurtleModel turtleModel;
    private TurtleWindow turtleWindow;
    private TurtleView turtleView;
    private ConsoleModel consoleModel;
    private Pen pen;
    private int index = 1;
    private double point;

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
        if (turtleModel.getClearedStatus()) {
            pen.clear(turtleWindow);
            turtleView.setX(turtleWindow.getViewWidth() / 2 - turtleView.getWidth() / 2);
            turtleView.setY(turtleWindow.getViewHeight() / 2 - turtleView.getHeight() / 2);
            turtleView.setRotate(0);
            turtleModel.setCleared(false);
        }
        else {
            turtleView.setVisible(true);
            //       if (turtleModel.getPenStatus()) {

            for (Object o : turtleModel.getPointList()) {
                if (index % 2 == 1) {
                    point = (double) o + turtleWindow.getViewWidth() / 2;
                    index = 2;
                } else {
                    point = (double) o * -1 + turtleWindow.getViewHeight() / 2;
                    index = 1;
                }
                pen.addPoint(point);
            }
            turtleModel.clearList();
            turtleWindow.getChildren().add(pen.draw(pen.getColor()));
            //  }
            turtleView.setX(turtleModel.getX() + turtleWindow.getViewWidth() / 2 - turtleView.getWidth() / 2);
            turtleView.setY(-turtleModel.getY() + turtleWindow.getViewHeight() / 2 - turtleView.getHeight() / 2);
            turtleView.setTurtleRotation(turtleModel.getAngle());
            turtleView.setVisible(turtleModel.getShowing());
        }
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
