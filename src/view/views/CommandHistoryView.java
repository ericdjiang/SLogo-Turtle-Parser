package view.views;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CommandHistoryView extends ScrollPane {
    private VBox content = new VBox();
    private List commandList;
    private int lineNum;

    public CommandHistoryView(ResourceBundle resources) {
        commandList = new ArrayList<Text>();
        setContent(content);
        lineNum = 1;
    }
    public void updateHistory(String input) {
        Text consoleInput = new Text(lineNum + input);
        commandList.add(input);
        consoleInput.setWrappingWidth(500); //remove magic number
        this.content.getChildren().add(consoleInput);
        lineNum ++;
    }
    public void displayError(String input) {
        if (input != null) {
            Text error = new Text(lineNum + "\t" + input);
            error.setFill(Color.RED);
            this.content.getChildren().add(error);
            lineNum++;
        }
    }
    private void clearHistory() {
        content.getChildren().removeAll(commandList);
    }
}
