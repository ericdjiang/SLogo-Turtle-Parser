package View;

import javafx.scene.layout.VBox;

public class VariableWindow extends VBox {

    public VariableWindow(ViewSwitchText historyText, ViewSwitchText referenceText, ViewSwitchText variableText, VariableView viewPane) {
        if (getChildren().size() > 1) {
            getChildren().clear();
        }
        getChildren().addAll(historyText, referenceText, variableText, viewPane);
    }
}
