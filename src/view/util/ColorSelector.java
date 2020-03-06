package view.util;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import javax.imageio.ImageIO;
import java.util.ResourceBundle;

public class ColorSelector extends StackPane {
    private static final String RESOURCES = "resources/languages";
    private static final String DEFAULT_RESOURCE_FOLDER = "/" + RESOURCES + "/";
    private Button backgroundButton;
    private ResourceBundle myResources;
    private ColorPicker colorPicker;

    public ColorSelector(String label) {
        this.colorPicker = new ColorPicker();
        this.backgroundButton = makeButton(label, e-> colorPicker.show());
        this.getStyleClass().add("colorbox");
        backgroundButton.getStyleClass().add("colorbutton");
        colorPicker.getStyleClass().add("colorpicker");
        colorPicker.hide();
        getChildren().add(colorPicker);
        getChildren().add(backgroundButton);
    }
    public ColorPicker getColorPicker() {
        return this.colorPicker;
    }
    public void updateLanguage(String language) {
        backgroundButton.setText(language);
    }
    public void setButtonColor(Color color) {
        //backgroundButton.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
    }
    private Button makeButton(String property, EventHandler<ActionEvent> handler) {
        // represent all supported image suffixes
        final String IMAGEFILE_SUFFIXES = String
                .format(".*\\.(%s)", String.join("|", ImageIO.getReaderFileSuffixes()));
        Button result = new Button();
        String label = property;
        if (label.matches(IMAGEFILE_SUFFIXES)) {
            result.setGraphic(new ImageView(
                    new Image(getClass().getResourceAsStream(DEFAULT_RESOURCE_FOLDER + label))));
        } else {
            result.setText(label);
        }
        result.setOnAction(handler);
        return result;
    }

}
