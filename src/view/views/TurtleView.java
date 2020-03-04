package view.views;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class TurtleView extends Rectangle {
    private Image ig = new Image("file:src/resources/images/turtle1.png");
    private ImagePattern turtlePattern = new ImagePattern(ig);

    public TurtleView() {
        setFill(turtlePattern);
        setWidth(50);
        setHeight(50);
    }
    public void setTurtleRotation(double r) {
        setRotate(r);
    }
    public void setImage(String l) {
        setFill(new ImagePattern(new Image("file:src/resources/images/" + l)));
    }
    public void switchTurtleImage() {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("src/resources/images"));
        Stage s = new Stage();
        File selected = fc.showOpenDialog(s);
        setImage(selected.getName());
    }
}
