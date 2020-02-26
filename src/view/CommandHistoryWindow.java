package view;

import javafx.scene.layout.VBox;

public class CommandHistoryWindow extends VBox {

    public CommandHistoryWindow(ViewSwitchText historyText, ViewSwitchText referenceText, ViewSwitchText variableText, CommandHistoryView viewPane) {
        if (this.getChildren().size() > 1) {
            this.getChildren().clear();
        }
        this.getChildren().add(historyText);
        this.getChildren().add(referenceText);
        this.getChildren().add(variableText);
        this.getChildren().add(viewPane);
    }
}
