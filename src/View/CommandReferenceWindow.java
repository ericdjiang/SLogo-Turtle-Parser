package View;

import javafx.scene.layout.VBox;

public class CommandReferenceWindow extends VBox {

    public CommandReferenceWindow(ViewSwitchText historyText, ViewSwitchText referenceText, ViewSwitchText variableText, CommandReferenceView viewPane) {
        if (getChildren().size() > 1) {
            getChildren().clear();
        }
        getChildren().addAll(historyText, referenceText, variableText, viewPane);
    }
}
