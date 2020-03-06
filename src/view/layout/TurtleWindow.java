package view.layout;

import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import model.TurtleModel;

public class TurtleWindow extends Pane {
    private int viewWidth = 540;
    private int viewHeight = 480;

    //TODO make zoomable
    public TurtleWindow() {
        this.setWidth(viewWidth);
        this.setHeight(viewHeight);
        this.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        this.getStyleClass().add("turtlewindow");
    }
    public double getViewWidth() {
        return this.viewWidth;
    }
    public double getViewHeight() {
        return this.viewHeight;
    }
}
