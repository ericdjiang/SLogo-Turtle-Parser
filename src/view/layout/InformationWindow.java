package view.layout;

import javafx.scene.Node;
import javafx.scene.layout.VBox;
import view.views.CommandHistoryView;
import view.views.InformationView;

public class InformationWindow extends VBox {

    public InformationWindow(ViewSwitchText historyText, ViewSwitchText referenceText, ViewSwitchText variableText, Node viewPane) {
        if (this.getChildren().size() > 1) {
            this.getChildren().clear();
        }
        this.getChildren().add(historyText);
        this.getChildren().add(referenceText);
        this.getChildren().add(variableText);
        this.getChildren().add(viewPane);
    }
}
