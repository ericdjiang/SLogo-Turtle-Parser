package view;

import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import model.TurtleModel;

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
        this.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
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
    public void setImage(String l) {
        turtle.setFill(new ImagePattern(new Image("file:src/resources/images/" + l)));
    }
}
