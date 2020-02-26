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
    public void updateHistory(Text input, Text output) {
        commandList.add(input);
        commandList.add(output);
        input.setWrappingWidth(900); //remove magic number
        output.setWrappingWidth(900);
        this.content.getChildren().add(input);
        this.content.getChildren().add(output);
    }
    private void clearHistory() {
        content.getChildren().removeAll(commandList);
    }
}
