package view;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CommandHistoryView extends ScrollPane {
    private VBox content = new VBox();
    private List commandList;

    public CommandHistoryView(ResourceBundle resources) {
        commandList = new ArrayList<Text>();
        setContent(content);
    }
    public void updateHistory(Text text) {
        commandList.add(text);
        text.setWrappingWidth(200); //remove magic number
        this.content.getChildren().add(text);
    }
    private void clearHistory() {
        content.getChildren().removeAll(commandList);
    }
}
