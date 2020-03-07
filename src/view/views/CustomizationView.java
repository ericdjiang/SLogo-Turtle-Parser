package view.views;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

import java.util.ResourceBundle;


public class CustomizationView extends ScrollPane {
    private final int DEFAULT = 1;
    private static final String STYLE = "vbox";

    private Slider dashWidthSlider;
    private Slider strokeThicknessSlider;

    private Text turtleX;
    private Text turtleY;
    private Text backgroundColor;
    private Text penColor;
    private Text penStatus;
    private Text turtleID;
    private Text turtleHeading;
    private Text penThickness;
    private Text penOffset;

    private double penOffsetVal;
    private double penThicknessVal;

    private boolean penThicknessChanged;

    private VBox content;
    private ResourceBundle resources;

    public CustomizationView(ResourceBundle resources) {
        this.resources = resources;
        initializeText();
        this.content = new VBox();
        content.setSpacing(50);
        setContent(content);
        this.penThicknessVal=DEFAULT;
        this.penOffsetVal=DEFAULT;

        initRowOne();
        initRowTwo();
        initRowThree();
    }
    private void initializeText() {
        turtleX = new Text(null);
        turtleY = new Text(null);
        backgroundColor = new Text(null);
        penColor = new Text(null);
        penStatus = new Text(null);
        turtleID = new Text(null);
        turtleHeading = new Text(null);
        penThickness = new Text(null);
        penOffset = new Text(null);
    }
    public void updateTurtleX(Double d) {
        turtleX.setText(resources.getString("TurtleX") + Double.toString(d.longValue()));
    }
    public void updateTurtleY(Double d) {
        turtleY.setText(resources.getString("TurtleY") + Double.toString(d.longValue()));
    }
    public void updatePenThickness() {
        Double d = strokeThicknessSlider.getValue();
        penThickness.setText(resources.getString("Stroke") + Double.toString(d.longValue()));
    }
    public void updatePenOffset() {
        Double d = dashWidthSlider.getValue();
        penOffset.setText(resources.getString("Dash") + Double.toString(d.longValue()));
    }
    public void updateTurtleID(Integer d) {
        turtleID.setText(resources.getString("TurtleID") + Integer.toString(d));
    }
    public void updateHeading(Double d) {
        turtleHeading.setText(resources.getString("TurtleHeading") + Double.toString(d.longValue()));
    }
    public void updatePenStatus(boolean b) {
        penStatus.setText(resources.getString("PenStatus") + b);
    }
    public void updatePenColor(Paint c) {
        penColor.setText(resources.getString("PenColor") + c.toString());
        penColor.setFill(c);
    }
    public void updateBackgroundColor(Paint c) {
        backgroundColor.setText(resources.getString("BackgroundColor") + c.toString());
        backgroundColor.setFill(c);
    }
    private void initRowOne() {
        dashWidthSlider = new Slider();
        strokeThicknessSlider = new Slider();
        HBox widthSliderField = new HBox();
        HBox thicknessSliderField = new HBox();
        widthSliderField.getChildren().add(dashWidthSlider);
        thicknessSliderField.getChildren().add(strokeThicknessSlider);
        widthSliderField.getChildren().add(new Text(resources.getString("DashSlider")));
        thicknessSliderField.getChildren().add(new Text(resources.getString("StrokeSlider")));
        createSliders(dashWidthSlider, 1, 50, 10);
        createSliders(strokeThicknessSlider, 1, 5, 0.5);
        dashWidthSlider.setOnMouseReleased(event -> savePenOffset(dashWidthSlider.getValue()));
        strokeThicknessSlider.setOnMouseReleased(event -> savePenThickness(strokeThicknessSlider.getValue()));
        content.getChildren().add(widthSliderField);
        content.getChildren().add(thicknessSliderField);
        content.getChildren().add(backgroundColor);
    }
    private void savePenOffset(Double d) {
        this.penOffsetVal = d;
    }
    private void savePenThickness(Double d) {

        this.penThicknessVal = d;
        penThicknessChanged = true;
    }
    private void initRowTwo() {
        content.getChildren().add(turtleX);
        content.getChildren().add(turtleY);
        content.getChildren().add(penThickness);
        content.getChildren().add(penOffset);
    }
    private void initRowThree() {
        content.getChildren().add(turtleID);
        content.getChildren().add(turtleHeading);
        content.getChildren().add(penStatus);
        content.getChildren().add(penColor);
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

    public void updateLanguage(ResourceBundle resources) {
        this.resources = resources;
        this.content.getChildren().clear();
        this.penThicknessVal=DEFAULT;
        this.penOffsetVal=DEFAULT;
        initRowOne();
        initRowTwo();
        initRowThree();
    }

    public boolean getPenChanged(){ return penThicknessChanged;}
    public void setPenChangedFalse(){penThicknessChanged=false;}

}
