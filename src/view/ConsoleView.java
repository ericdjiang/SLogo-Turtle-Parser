package view;

import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ResourceBundle;

public class ConsoleView extends TextArea {
    private final ResourceBundle myResources;

    private final VBox prompt = new VBox();
    private final String style = "-fx-background-color: rgb(0,0,0);";
    private Text carot;

    public ConsoleView(ResourceBundle resources) {
        this.myResources = resources;
        this.setPromptText(myResources.getString("EnterText"));
        this.prompt.setBackground(Background.EMPTY);
        this.prompt.setStyle(style);
        this.setStyle(style);
        setOnKeyPressed(event -> addNewCarot(event.getCode()));
        addNewCarot(KeyCode.ENTER);
    }
    public Node getPrompt() {
        return this.prompt;
    }
    public void updateLanguage(ResourceBundle resources) {
        this.setPromptText(resources.getString("EnterText"));
    }
    private void addNewCarot(KeyCode code) {
        if (code == KeyCode.ENTER) {
            carot = new Text(">");
            carot.setFill(Color.WHITE);
            prompt.getChildren().add(carot);
        }
    }

}
