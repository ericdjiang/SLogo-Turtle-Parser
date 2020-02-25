package View;

import javafx.scene.control.TextArea;

import java.util.ResourceBundle;

public class Console extends TextArea {
    private final ResourceBundle myResources;

    public Console(ResourceBundle resources) {
        this.myResources = resources;
        setPromptText(myResources.getString("EnterText"));
    }


}
