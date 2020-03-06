package controller;

import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.util.Duration;
import model.ConsoleModel;
import model.TurtleContainer;
import model.TurtleModel;
import view.util.Pen;
import view.views.TurtleView;
import view.layout.TurtleWindow;

import java.awt.desktop.SystemSleepEvent;

public class Controller {
    private TurtleWindow turtleWindow;
    private ConsoleModel consoleModel;
    private TurtleContainer turtleContainer;
    private Pen pen;
    private int index = 1;
    private double point;
    private double oldx;
    private double oldy;

    public Controller(TurtleWindow turtleFrontEnd, ConsoleModel consoleModel, TurtleContainer turtleContainer) {
        this.turtleContainer = turtleContainer;
        //TODO javafx transitions rotate and move
        this.turtleWindow = turtleFrontEnd;
        this.consoleModel = consoleModel;
        this.pen = new Pen();
        for(TurtleModel turtleModel : turtleContainer.getTurtleModelContainer().getTurtleModels()){
            TurtleView turtleView = turtleContainer.getTurtleView(turtleModel.getModelId());
            oldx = turtleModel.getX() + turtleWindow.getViewWidth()/2 - turtleView.getWidth()/2;
            oldy = -turtleModel.getY() + turtleWindow.getViewHeight()/2 - turtleView.getHeight()/2;
            turtleView.setX(turtleModel.getX() + turtleWindow.getViewWidth()/2 - turtleView.getWidth()/2);
            turtleView.setY(-turtleModel.getY() + turtleWindow.getViewHeight()/2 - turtleView.getHeight()/2);
         //   turtleWindow.getChildren().add(turtleView);
        }

    }
    double xcoord;
    double ycoord;
    public void update() {
        for(int t = 1; t <= turtleContainer.getTurtleModelContainer().getTurtleModels().size(); t++){
            TurtleModel turtleModel = turtleContainer.getTurtleModelContainer().getTurleModel(t);
            int id = turtleModel.getModelId();
            TurtleView turtleView = turtleContainer.getTurtleView(id);



            if (turtleModel.getClearedStatus()) {
                pen.clear(turtleWindow);
                turtleView.setX(turtleWindow.getViewWidth() / 2 - turtleView.getWidth() / 2);
                turtleView.setY(turtleWindow.getViewHeight() / 2 - turtleView.getHeight() / 2);
                turtleView.setRotate(0);
                turtleModel.setCleared(false);
            }
            else {
                if (turtleModel.getPenStatus()) {
//correct one
//            for (Object o : turtleModel.getPointList()) {
//                if (index % 2 == 1) {
//                    point = (double) o + turtleWindow.getViewWidth() / 2;
//                    index = 2;
//                } else {
//                    point = (double) o * -1 + turtleWindow.getViewHeight() / 2;
//                    index = 1;
//                }
//                pen.addPoint(point);


//                if (point < turtleWindow.getViewHeight() && point < turtleWindow.getViewWidth() && point > 0 && point > 0) {
//                    pen.addPoint(point);
//                }
//                else {
//                    if (point > turtleWindow.getViewHeight()) {
//                        point = turtleWindow.getViewHeight();
//                    }
//                    else if (point > turtleWindow.getViewWidth()) {
//                        point = turtleWindow.getViewWidth();
//                    }
//                    pen.addPoint(point);
//                }
                    for (int i = 0; i < turtleModel.getPointList().size(); i += 2) {
                        Object x = (double) turtleModel.getPointList().get(i) + turtleWindow.getViewWidth() / 2 - turtleView.getWidth() / 2;
                        Object y = (double) turtleModel.getPointList().get(i + 1) * -1 + turtleWindow.getViewHeight() / 2 - turtleView.getHeight() / 2;
                        TranslateTransition translate = new TranslateTransition();
                        if (oldx != (double) x || oldy != (double) y) {
                            System.out.println(x + " " + oldx);
                            System.out.println(y + " " + oldy);
                            xcoord += (double) x-oldx;
                            ycoord += (double) y-oldy;
                            translate.setToX(xcoord);
                            translate.setToY(ycoord);
                            int timer = 600;
                            translate.setDuration(Duration.millis(600));
                            translate.setNode(turtleView);
                            translate.play();
                            while (timer != 0){
                                timer --;
                            }
                            oldx = (double) x;
                            oldy = (double) y;
//                        translate.setFromX((double) x - oldx);
//                        translate.setFromY((double) y - oldy);

                        }

                        //           if (oldx != turtleModel.getX() + turtleWindow.getViewWidth()/2 - turtleView.getWidth()/2 || oldy != -turtleModel.getY() + turtleWindow.getViewHeight() / 2 - turtleView.getHeight() / 2) {
//                    if (oldx != (double) x || oldy != (double) y) {
//                        Path path = new Path();
//                        path.setFill(Color.BLACK);
//                        path.getElements().add(new MoveTo(oldx, oldy));
////                        path.getElements().add(new LineTo(turtleModel.getX() + turtleWindow.getViewWidth() / 2 - turtleView.getWidth() / 2, -turtleModel.getY() + turtleWindow.getViewHeight() / 2 - turtleView.getHeight() / 2));
//                        path.getElements().add(new LineTo((double) x, (double) y));
//                        oldx = turtleModel.getX() + turtleWindow.getViewWidth() / 2 - turtleView.getWidth() / 2;
//                        oldy = -turtleModel.getY() + turtleWindow.getViewHeight() / 2 - turtleView.getHeight() / 2;
//                        oldx = (double) x;
//                        oldy = (double) y;
//                        PathTransition pt = new PathTransition();
//                        path.setFill(Color.BLACK);
//                        turtleWindow.getChildren().add(path);
//                        pt.setPath(path);
//                        pt.setNode(turtleView);
//                        pt.setDuration(Duration.millis(60));
//                        pt.setOrientation(PathTransition.OrientationType.NONE);
//                        pt.play();
//                    }
                    }
                    turtleModel.clearList();
                    //  turtleWindow.getChildren().add(pen.draw(pen.getColor()));
                }
                else {
                    turtleModel.trackPos();
                    pen.pickUp();
                }

                //turtleView.setX(turtleModel.getX() + turtleWindow.getViewWidth() / 2 - turtleView.getWidth() / 2);
                //turtleView.setY(-turtleModel.getY() + turtleWindow.getViewHeight() / 2 - turtleView.getHeight() / 2);

//            RotateTransition rt = new RotateTransition(Duration.millis(60));
//            rt.setNode(turtleView);
//            rt.setAxis(Rotate.Z_AXIS);
//            rt.setToAngle(turtleModel.getAngle());
//            rt.play();
                // System.out.println("x" + turtleView.getX() + "y" + turtleView.getY());
                turtleView.setTurtleRotation(turtleModel.getAngle());
                turtleView.setVisible(turtleModel.getShowing());
            }

        }

    }


    public Pen getPen() {
        return this.pen;
    }
    public ConsoleModel getConsoleModel() { return this.consoleModel; }
}

