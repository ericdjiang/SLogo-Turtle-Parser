package view.views;

import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;


public class CustomizationView extends VBox {
    private final int DEFAULT = 1;
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
    private double penOffsetVal=1;
    private double penThicknessVal=1;
    private HBox row1;
    private HBox row2;
    private HBox row3;

    public CustomizationView() {
        row1 = new HBox();
        row2 = new HBox();
        row3 = new HBox();
        initRowOne();
        initRowTwo();
        initRowThree();
        getChildren().add(row1);
        getChildren().add(row2);
        getChildren().add(row3);
    }
    public void updateTurtleX(Double d) {
        turtleX.setText("XPos: " + Double.toString(d.longValue()));
    }
    public void updateTurtleY(Double d) {
        turtleY.setText("YPos: " + Double.toString(d.longValue()));
    }
    public void updatePenThickness() {
        Double d = strokeThicknessSlider.getValue();
        penThickness.setText("Stroke Thickness: " + Double.toString(d.longValue()));
    }
    public void updatePenOffset() {
        Double d = dashWidthSlider.getValue();
        penOffset.setText("Dash Width: " + Double.toString(d.longValue()));
    }
    public void updateTurtleID(Integer d) {
        turtleID.setText("ID: " + Integer.toString(d));
    }
    public void updateHeading(Double d) {
        turtleHeading.setText("Heading: " + Double.toString(d.longValue()));
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
    private void initRowOne() {
        dashWidthSlider = new Slider();
        strokeThicknessSlider = new Slider();
        createSliders(dashWidthSlider, 1, 50, 10);
        createSliders(strokeThicknessSlider, 1, 5, 0.5);
        dashWidthSlider.setOnMouseReleased(event -> savePenOffset(dashWidthSlider.getValue()));
        strokeThicknessSlider.setOnMouseReleased(event -> savePenThickness(strokeThicknessSlider.getValue()));
        row1.getChildren().add(dashWidthSlider);
        row1.getChildren().add(strokeThicknessSlider);
        row1.getChildren().add(backgroundColor);
    }
    private void savePenOffset(Double d) {
        this.penOffsetVal = d;
    }
    private void savePenThickness(Double d) {
        this.penThicknessVal = d;
    }
    private void initRowTwo() {
        row2.getChildren().add(turtleX);
        row2.getChildren().add(turtleY);
        row2.getChildren().add(penThickness);
        row2.getChildren().add(penOffset);
    }
    private void initRowThree() {
        row3.getChildren().add(turtleID);
        row3.getChildren().add(turtleHeading);
        row3.getChildren().add(penStatus);
        row3.getChildren().add(penColor);
    }
    private void createSliders(Slider name, double min, double max, double interval) {
        name.setMin(min);
        name.setMax(max);
        name.setValue(DEFAULT);
        name.setShowTickLabels(true);
        name.setShowTickMarks(true);
        name.setBlockIncrement(interval);
    }
    public Double getPenStrokeWidth() {
        return this.penThicknessVal;
    }
    public Double getPenStrokeOffset() {
        return this.penOffsetVal;
    }
}
