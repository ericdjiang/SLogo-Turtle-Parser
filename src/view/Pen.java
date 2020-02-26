package view;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polyline;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Pen {
    private List myPoints;
    private Collection myCoordinates;
    private Paint color;
    private List myLines;

    public Pen() {
        this.myPoints = new ArrayList();
        this.color = Color.BLACK;
        this.myLines = new ArrayList();
    }
    public void addPoint(double x1, double y1, double x2, double y2) {
        myPoints.add(x1);
        myPoints.add(y1);
        myPoints.add(x2);
        myPoints.add(y2);
    }
    public Polyline draw(Paint c) {
        Polyline p = new Polyline();
        myCoordinates = Arrays.asList(myPoints.toArray());
        p.getPoints().addAll(myCoordinates);
        p.setStroke(c);
        myPoints.clear();
        return p;
    }
    public void setColor(Paint color) {
        this.color = color;
    }
    public Paint getColor() {
        return this.color;
    }
    public void clear() {
        for (Object o : myLines) {
            Polyline p = (Polyline) o;
            p.getPoints().clear();
        }
    }
}
