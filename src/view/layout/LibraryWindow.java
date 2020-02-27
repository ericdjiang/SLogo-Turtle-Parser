package view.layout;

import javafx.scene.layout.VBox;
import view.views.LibraryView;

public class LibraryWindow extends VBox {

    public LibraryWindow(ViewSwitchText historyText, ViewSwitchText referenceText, ViewSwitchText variableText, LibraryView viewPane) {
        if (getChildren().size() > 1) {
            getChildren().clear();
        }
        getChildren().addAll(historyText, referenceText, variableText, viewPane);
    }
}
