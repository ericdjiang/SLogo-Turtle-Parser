package View;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class VariableView extends ScrollPane {
    private VBox content = new VBox();
    private ResourceBundle resources;

    public VariableView(ResourceBundle resources) throws IOException {
        this.resources = resources;
        content.getChildren().add(new Text("X=42"));
        setContent(content);
    }




}
