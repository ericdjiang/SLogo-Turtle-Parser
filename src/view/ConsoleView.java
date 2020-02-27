package view;

import javafx.scene.control.TextArea;

import java.util.ResourceBundle;

public class ConsoleView extends TextArea {
    private final ResourceBundle myResources;

    public ConsoleView(ResourceBundle resources) {
        this.myResources = resources;
        this.setPromptText(myResources.getString("EnterText"));
    }
    public void updateLanguage(ResourceBundle resources) {
        this.setPromptText(resources.getString("EnterText"));
    }

}
