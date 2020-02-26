package view;

import javafx.scene.shape.Polyline;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Pen extends Polyline {
    private double xPos;
    private double yPos;
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
}
