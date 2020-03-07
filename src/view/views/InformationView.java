package view.views;

import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ResourceBundle;

public abstract class InformationView extends ScrollPane {
    protected VBox frame = new VBox();
    protected HBox header = new HBox();
    protected VBox body = new VBox();
    protected ResourceBundle resources;

    public InformationView(ResourceBundle resources) {
        this.resources = resources;
        setContent(frame);
        header.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        frame.getChildren().add(header);
        frame.getChildren().add(body);
    }
    protected void clear() {
        body.getChildren().clear();
    }
    protected void addEntry(Node entry) {
        body.getChildren().add(entry);
    }
}
