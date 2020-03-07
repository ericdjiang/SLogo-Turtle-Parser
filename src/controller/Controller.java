package controller;

import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.util.Duration;
import javafx.scene.Node;
import model.*;
import parsing.Parser;
import view.util.ControlPanel;
import view.util.Pen;
import view.views.*;
import view.layout.TurtleWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller {
    private TurtleWindow turtleWindow;
    private TurtleContainer turtleContainer;

    private CustomizationView customization;
    private VariableView variableView;
    private CommandHistoryView historyView;
    private LibraryView libraryView;

    private PaletteModel paletteModel;
    private ConsoleModel consoleModel;
    private VariableModel variableModel;
    private Map<String, MethodModel> methodModels;
    private Pen pen;
    private Parser parser;
    private int index = 1;
    private double point;
    private double oldx;
    private double oldy;
    private ModelContainer allModels;


    public Controller(TurtleWindow turtleWindow, CustomizationView dynamicStats, CommandHistoryView historyView, VariableView variableView, LibraryView libraryView) {
        this.turtleWindow = turtleWindow;
        this.turtleContainer = new TurtleContainer(turtleWindow);
        turtleContainer.addTurtle(1);
        turtleContainer.getTurtleModelContainer().makeTurtleActive(1);
        this.consoleModel = new ConsoleModel();
        this.variableModel = new VariableModel();
        this.paletteModel = new PaletteModel();
        this.variableView = variableView;
        this.libraryView = libraryView;
        this.customization = dynamicStats;
        this.methodModels = new HashMap<>();
        this.historyView = historyView;
        this.pen = new Pen();
        for(TurtleModel turtleModel : turtleContainer.getTurtleModelContainer().getTurtleModels()){
            TurtleView turtleView = turtleContainer.getTurtleView(turtleModel.getModelId());
            oldx = turtleModel.getX() + turtleWindow.getViewWidth()/2 - turtleView.getWidth()/2;
            oldy = -turtleModel.getY() + turtleWindow.getViewHeight()/2 - turtleView.getHeight()/2;
            turtleView.setX(turtleModel.getX() + turtleWindow.getViewWidth()/2 - turtleView.getWidth()/2);
            turtleView.setY(-turtleModel.getY() + turtleWindow.getViewHeight()/2 - turtleView.getHeight()/2);
            //turtleWindow.getChildren().add(turtleView);
        }

    }
    double xcoord;
    double ycoord;
    public void update() {

        if (variableView.isChangedVariables()) {
        }

        if(turtleContainer.getTurtleModelContainer().getActiveTurtles().get(0).getIsColorChanged()){
            List<Double> colorVals = turtleContainer.getTurtleModelContainer().getActiveTurtles().get(0).getBackgroundColor();
            turtleWindow.setColor(new Color(colorVals.get(0), colorVals.get(1), colorVals.get(2), 1));
            allModels.getTurtleModelContainer().getActiveTurtles().get(0).setColorChanged(false);
        }



        for(int t = 1; t <= turtleContainer.getTurtleModelContainer().getTurtleModels().size(); t++){
            TurtleModel turtleModel = turtleContainer.getTurtleModelContainer().getTurleModel(t);
            customization.updateTurtleX(turtleModel.getX());
            customization.updateTurtleY(turtleModel.getY());
            customization.updatePenOffset();
            customization.updatePenThickness();
            int id = turtleModel.getModelId();
            customization.updateTurtleID(id);
            customization.updateHeading(turtleModel.getAngle());
            customization.updatePenStatus(turtleModel.getPenStatus());
            customization.updatePenColor(pen.getColor());
            customization.updateBackgroundColor(turtleWindow.getColor());

            if ( turtleContainer.getTurtleView(id) == null){
                TurtleView newTurtleView = turtleContainer.addTurtleView(id);
                turtleWindow.getChildren().add(newTurtleView);
                newTurtleView.setX(turtleWindow.getViewWidth()/2 - newTurtleView.getWidth()/2);
                newTurtleView.setY( turtleWindow.getViewHeight()/2 - newTurtleView.getHeight()/2);
            }
            TurtleView turtleView = turtleContainer.getTurtleView(id);

            pen.setStrokeWidth(customization.getPenStrokeWidth());
            pen.setDashOffset(customization.getPenStrokeOffset());


            if (turtleModel.getClearedStatus()) {
                pen.clear(turtleWindow);
                turtleView.setX(turtleWindow.getViewWidth() / 2 - turtleView.getWidth() / 2);
                turtleView.setY(turtleWindow.getViewHeight() / 2 - turtleView.getHeight() / 2);
                turtleView.setRotate(0);
                turtleModel.setCleared(false);
            }
            else {
                if (turtleModel.getPenStatus()) {
                    if (                point > turtleWindow.getViewHeight() && point > turtleWindow.getViewWidth() && point < 0 && point < 0) {
                        turtleView.setVisible(false);
                    }
//correct one
            for (Object o : turtleModel.getPointList()) {
                if (index % 2 == 1) {
                    point = (double) o + turtleWindow.getViewWidth() / 2;
                    index = 2;
                } else {
                    point = (double) o * -1 + turtleWindow.getViewHeight() / 2;
                    index = 1;
                }
                pen.addPoint(point);


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

                //animation
//                    for (int i = 0; i < turtleModel.getPointList().size(); i += 2) {
//                        Object x = (double) turtleModel.getPointList().get(i) + turtleWindow.getViewWidth() / 2 - turtleView.getWidth() / 2;
//                        Object y = (double) turtleModel.getPointList().get(i + 1) * -1 + turtleWindow.getViewHeight() / 2 - turtleView.getHeight() / 2;
//                        TranslateTransition translate = new TranslateTransition();
//                        if (oldx != (double) x || oldy != (double) y) {
//                            System.out.println(x + " " + oldx);
//                            System.out.println(y + " " + oldy);
//                            xcoord += (double) x-oldx;
//                            ycoord += (double) y-oldy;
//                            translate.setToX(xcoord);
//                            translate.setToY(ycoord);
//                            int timer = 600;
//                            translate.setDuration(Duration.millis(600));
//                            translate.setNode(turtleView);
//                            translate.play();
//                            while (timer != 0){
//                                timer --;
//                            }
//                            oldx = (double) x;
//                            oldy = (double) y;
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

                    turtleModel.clearList();
                //for working one
                    turtleWindow.getChildren().add(pen.draw(pen.getColor()));
                }
                else {
                    turtleModel.trackPos();
                    pen.pickUp();
                }
//needed for correct one
                turtleView.setX(turtleModel.getX() + turtleWindow.getViewWidth() / 2 - turtleView.getWidth() / 2);
                turtleView.setY(-turtleModel.getY() + turtleWindow.getViewHeight() / 2 - turtleView.getHeight() / 2);


//            RotateTransition rt = new RotateTransition(Duration.millis(60));
//            rt.setNode(turtleView);
//            rt.setAxis(Rotate.Z_AXIS);
//            rt.setToAngle(turtleModel.getAngle());
//            rt.play();
                // System.out.println("x" + turtleView.getX() + "y" + turtleView.getY());
                turtleView.setTurtleRotation(turtleModel.getAngle());
                turtleView.setVisible(turtleModel.getShowing());
            }
            turtleView.changeToolTip(turtleView.getViewId(), turtleModel.getX(),turtleModel.getY(),turtleModel.getAngle());
        }


    }
    public void setPenColor(Paint color) {
        pen.setColor(color);
    }

    public void updateVariableView() {
        if (variableModel.newVarAdded()) {
            variableView.addVariable(variableModel.getVariableName(), variableModel.getVariableInfo());
            variableModel.clearVarInfo();
        }
        variableModel.varReceived();
    }
    public void updateLibraryView() {
        for (String k :  methodModels.keySet()) {
            libraryView.addMethod(methodModels.get(k).getMethodName(), methodModels.get(k).getVariableNames(), methodModels.get(k).getMethodBody());
        }
    }
    public void updateInputHistory(String commands){
        if (! consoleModel.getErrorMessage().equals(null)) {
            historyView.displayError(consoleModel.getErrorMessage());
        }
        else {
            historyView.updateHistory(commands, consoleModel.getReturnVal());
        }
        consoleModel.setErrorMessage(null);
    }
    public void createParser(String commands) {
        allModels = new ModelContainer(variableModel, consoleModel, methodModels, turtleContainer.getTurtleModelContainer(), paletteModel);
        parser = new Parser(commands, "English", allModels);
    }
    public void setBGColor(Color color) {
        for(int t = 1; t <= turtleContainer.getTurtleModelContainer().getTurtleModels().size(); t++) {
            TurtleModel turtleModel = turtleContainer.getTurtleModelContainer().getTurleModel(t);
            List<Double> l = new ArrayList<>();
            l.add(color.getGreen());
            l.add(color.getRed());
            l.add(color.getBlue());
            turtleModel.setBackgroundColor(l);
        }
    }
}

