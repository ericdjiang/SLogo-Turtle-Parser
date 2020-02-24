package View;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.io.File;

public class TurtleView extends Pane {
    private Rectangle turtle; //change to Turtle object when created
    private Image ig = new Image("file:src/resources/images/turtle1.png");
    private ImagePattern turtlePattern = new ImagePattern(ig);
    private int viewWidth = 650;
    private int viewHeight = 480;

    public TurtleView() {
        this.turtle = new Rectangle(50, 50);
        getChildren().add(turtle);
        setWidth(viewWidth);
        setHeight(viewHeight);
        turtle.setX(viewWidth/2-turtle.getWidth()/2);
        turtle.setY(viewHeight/2-turtle.getHeight()/2);
        turtle.setFill(turtlePattern);

    }
    public double getTurtleXPos() {
        return turtle.getX();
    }
    public double getTurtleYPos() {
        return turtle.getY();
    }
    public double getTurtleRotation() {
        return turtle.getRotate();
    }
    public void setTurtleXPos(double x) {
        turtle.setX(x);
    }
    public void setTurtleYPos(double y) {
        turtle.setY(y);
    }
    public void setTurtleRotation(double r) {
        turtle.setRotate(r);
    }
}