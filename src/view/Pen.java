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
    private double lastX;
    private double lastY;

    public Pen() {
        this.myPoints = new ArrayList();
        this.color = Color.BLACK;
        this.myLines = new ArrayList<Polyline>();
    }
    public void addPoint(double p) {
        myPoints.add(p);
    }
    public Polyline draw(Paint c) {
        Polyline p = new Polyline();
        myCoordinates = Arrays.asList(myPoints.toArray());
        p.getPoints().addAll(myCoordinates);
        p.setStroke(c);
        myLines.add(p);
        lastX = (double) myPoints.get(myPoints.size()-2);
        lastY = (double) myPoints.get(myPoints.size()-1);
        myPoints.clear();
        myPoints.add(lastX);
        myPoints.add(lastY);
        return p;
    }
    public void setColor(Paint color) {
        this.color = color;
    }
    public Paint getColor() {
        return this.color;
    }
    public void clear(TurtleWindow root) {
        for (Object o : myLines) {
            Polyline p;
            p = (Polyline) o;
            p.getPoints().clear();
            root.getChildren().remove(p);
        }
        myLines.clear();
    }
}
