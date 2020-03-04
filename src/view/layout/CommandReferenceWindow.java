package view.layout;

import javafx.scene.layout.VBox;
import view.views.CommandReferenceView;

public class CommandReferenceWindow extends VBox {

    public CommandReferenceWindow(ViewSwitchText historyText, ViewSwitchText referenceText, ViewSwitchText variableText, CommandReferenceView viewPane) {
        if (getChildren().size() > 1) {
            getChildren().clear();
        }
        getChildren().addAll(historyText, referenceText, variableText, viewPane);
    }
}
