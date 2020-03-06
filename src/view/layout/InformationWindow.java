package view.layout;

import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import view.views.CommandHistoryView;
import view.views.InformationView;

public class InformationWindow extends VBox {

    public InformationWindow(Node tabs, Node viewPane) {
        if (this.getChildren().size() > 1) {
            this.getChildren().clear();
        }
        this.getChildren().add(tabs);
        this.getChildren().add(viewPane);
    }
}
