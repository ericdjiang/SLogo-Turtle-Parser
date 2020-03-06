package view.views;

import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;


public class CustomizationView extends VBox {
    private Slider dashWidthSlider;
    private Slider strokeThicknessSlider;
    private Text turtleX = new Text(null);
    private Text turtleY = new Text(null);
    private Text backgroundColor = new Text(null);
    private Text penColor = new Text(null);
    private Text penStatus = new Text(null);
    private Text turtleID = new Text(null);
    private Text turtleHeading = new Text(null);
    private Text penThickness = new Text(null);
    private Text penOffset = new Text(null);
    private HBox row1 = new HBox();
    private HBox row2 = new HBox();
    private HBox row3 = new HBox();
    private HBox row4 = new HBox();

    public CustomizationView() {
        dashWidthSlider = new Slider();
        dashWidthSlider.setMin(1);
        dashWidthSlider.setMax(50);
        dashWidthSlider.setValue(0);
        dashWidthSlider.setShowTickLabels(true);
        dashWidthSlider.setShowTickMarks(true);
        dashWidthSlider.setBlockIncrement(10);
        row1.getChildren().add(dashWidthSlider);
        strokeThicknessSlider = new Slider();
        strokeThicknessSlider.setMin(1);
        strokeThicknessSlider.setMax(5);
        strokeThicknessSlider.setValue(1);
        strokeThicknessSlider.setShowTickLabels(true);
        strokeThicknessSlider.setShowTickMarks(true);
        strokeThicknessSlider.setBlockIncrement(0.5);
        row1.getChildren().add(strokeThicknessSlider);
        getChildren().add(row1);

        row2.getChildren().add(turtleX);
        row2.getChildren().add(turtleY);
        row2.getChildren().add(penThickness);
        row2.getChildren().add(penOffset);
        getChildren().add(row2);

        row3.getChildren().add(turtleID);
        row3.getChildren().add(turtleHeading);
        row3.getChildren().add(penStatus);
        row3.getChildren().add(penColor);
        getChildren().add(row3);

        row4.getChildren().add(backgroundColor);
        getChildren().add(row4);
    }
    public double getDashWidth() {
        return this.dashWidthSlider.getValue();
    }
    public double getThickness() {
        return this.strokeThicknessSlider.getValue();
    }
    public void updateTurtleX(Double d) {
        turtleX.setText("XPos: " + Double.toString(d.floatValue()));
    }
    public void updateTurtleY(Double d) {
        turtleY.setText("YPos: " + Double.toString(d.floatValue()));
    }
    public void updatePenThickness() {
        Double d = strokeThicknessSlider.getValue();
        penThickness.setText("Stroke Thickness: " + Double.toString(d.floatValue()));
    }
    public void updatePenOffset() {
        Double d = dashWidthSlider.getValue();
        penOffset.setText("Dash Width: " + Double.toString(d.floatValue()));
    }
    public void updateTurtleID(Integer d) {
        turtleID.setText("ID: " + Integer.toString(d));
    }
    public void updateHeading(Double d) {
        turtleHeading.setText("Heading: " + Double.toString(d.floatValue()));
    }
    public void updatePenStatus(boolean b) {
        penStatus.setText("IsPenDown: " + b);
    }
    public void updatePenColor(Paint c) {
        penColor.setText("PenColor: " + c.toString());
        penColor.setFill(c);
    }
    public void updateBackgroundColor(Paint c) {
        backgroundColor.setText("BackgroundColor: " + c.toString());
        backgroundColor.setFill(c);
    }
}
