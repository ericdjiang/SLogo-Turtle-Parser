package view.views;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyCode;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ResourceBundle;

public class ConsoleView extends TextArea {
    private static final int PROMPT_LIMIT = 7;
    private static final String PROMPT_SYMBOL = ">";
    private final ResourceBundle myResources;

    private final VBox prompt = new VBox();
    private final String style = "-fx-background-color: rgb(0,0,0);";
    private Text promptSymbol;
    private int numEntries;

    public ConsoleView(ResourceBundle resources) {
        handleDragOver();
        this.myResources = resources;
        this.setPromptText(myResources.getString("EnterText"));
        this.prompt.setBackground(Background.EMPTY);
        this.prompt.setStyle(style);
        this.setStyle(style);
        setOnKeyPressed(event -> addNewPromptSymbol(event.getCode()));
        addNewPromptSymbol(KeyCode.ENTER);
    }
    private void handleDragOver(){
        this.setOnDragOver(e->{
            if(e.getDragboard().hasString()){
                e.acceptTransferModes(TransferMode.MOVE);
            }
            //this.setText(e.getDragboard().getString());
            e.consume();
        });
        this.setOnDragEntered(e->{
            if(e.getDragboard().hasString()){
                this.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
            }
        });
        this.setOnDragExited(e->{
            this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        });
        this.setOnDragDropped(e->{
            Dragboard db = e.getDragboard();
            boolean success = false;
            if(db.hasString()){
                this.setText(db.getString());
                success = true;
            }
            e.setDropCompleted(success);
            e.consume();
        });
    }
    public Node getPrompt() {
        return this.prompt;
    }
    public void updateLanguage(ResourceBundle resources) {
        this.setPromptText(resources.getString("EnterText"));
    }
    private void addNewPromptSymbol(KeyCode code) {
        if (code == KeyCode.ENTER && numEntries < PROMPT_LIMIT) {
            promptSymbol = new Text(PROMPT_SYMBOL);
            promptSymbol.setFill(Color.WHITE);
            prompt.getChildren().add(promptSymbol);
            numEntries ++;
        }
    }

}

