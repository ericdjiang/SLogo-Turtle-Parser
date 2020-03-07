package view.util;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.StrokeType;
import view.layout.TurtleWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Pen {
    private final double DEFAULT = 1.0;
    private List<Double> myPoints;
    private Collection myCoordinates;
    private Paint color;
    private List<Polyline> myLines;
    private double lastX;
    private double lastY;
    private double dashOffset;
    private double strokeWidth;

    public Pen() {
        this.myPoints = new ArrayList();
        this.color = Color.BLACK;
        this.myLines = new ArrayList<>();
        this.dashOffset=DEFAULT;
        this.strokeWidth=DEFAULT;
    }
    public void addPoint(double p) {
        myPoints.add(p);
    }
    public Polyline draw(Paint color) {
            Polyline line = new Polyline();
            line.getStrokeDashArray().add(dashOffset);
            line.setStrokeWidth(strokeWidth);
            myCoordinates = Arrays.asList(myPoints.toArray());
            line.getPoints().addAll(myCoordinates);
            line.setStroke(color);
            myLines.add(line);
            lastX = myPoints.get(myPoints.size() - 2);
            lastY = myPoints.get(myPoints.size() - 1);
            myPoints.clear();
            myPoints.add(lastX);
            myPoints.add(lastY);
            return line;
        }
    public void setColor(Paint color) {
        this.color = color;
    }
    public Paint getColor() {
        return this.color;
    }
    public void pickUp() {
        myPoints.clear();
    }
    public void clear(TurtleWindow root) {
        for (Polyline line : myLines) {
            line.getPoints().clear();
            root.getChildren().remove(line);
        }
        myLines.clear();
        myPoints.clear();
    }
    public void setDashOffset(double spacing) {
        dashOffset = spacing;
    }
    public void setStrokeWidth(double width) {
        strokeWidth = width;
    }
}
