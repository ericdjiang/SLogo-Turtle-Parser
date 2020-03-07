package view.layout;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.TurtleModel;

import java.util.List;

public class TurtleWindow extends Pane {
    private final int viewWidth = 540;
    private final int viewHeight = 400;
    private Paint color;

    public TurtleWindow() {
        this.setWidth(200);
        this.setHeight(200);
        this.getStyleClass().add("turtlewindow");
        this.color = Color.LIGHTBLUE;
    }
    public double getViewWidth() {
        return this.viewWidth;
    }
    public double getViewHeight() {
        return this.viewHeight;
    }
    public void setColor(Paint color) {
        this.color = color;
        setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
    }
    public Paint getColor() {
        return this.color;
    }
    public void displayWarning() {
        String error = "Warning: Turtle left view area. It's line may or may not have been drawn to completion.\n Use the command: cs st pd to reset it back to its original state";
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("OffScreenWarning");
        alert.setHeaderText(error);
        Platform.runLater(alert::showAndWait);
    }
}
