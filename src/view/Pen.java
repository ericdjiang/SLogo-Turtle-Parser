package view;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polyline;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
//FIXME edit so that one line can have different colors after basic
public class Pen extends Polyline {
    private List myPoints;
    private Collection myCoordinates;

    public Pen() {
        this.myPoints = new ArrayList();
    }
    public void addPoint(double x, double y) {
        myPoints.add(x);
        myPoints.add(y);
    }
    public void draw() {
        myCoordinates = Arrays.asList(myPoints.toArray());
        getPoints().addAll(myCoordinates);
        myPoints.clear();
    }
    public void setColor(Paint color) {
        setStroke(color);
    }
}
