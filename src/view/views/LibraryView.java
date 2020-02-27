package view.views;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ResourceBundle;
//TODO separate into hboxs
public class LibraryView extends ScrollPane {
    private VBox content = new VBox();
    private ResourceBundle resources;

    public LibraryView(ResourceBundle resources) {
        this.resources = resources;
        setContent(content);
    }
    public void addMethod(Text t) {
        this.content.getChildren().add(t);
    }




}
