package view;

import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import model.TurtleModel;

public class TurtleWindow extends Pane {
    private int viewWidth = 650;
    private int viewHeight = 480;

    public TurtleWindow() {
        this.setWidth(viewWidth);
        this.setHeight(viewHeight);
        this.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }
}
