package view.views;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;
public class LibraryView extends InformationView {
    private static final String STYLE = "vbox";

    public LibraryView(ResourceBundle resources) {
        super(resources);
        setHeader();

    }
    public void addMethod(String name, List<String> variables, String body) {
        Text methodName = new Text(name);
        Text methodBody = new Text(body);
        methodName.setWrappingWidth(250);
        methodBody.setWrappingWidth(250);
        VBox names = new VBox();
        VBox bodies = new VBox();
        names.getStyleClass().add(STYLE);
        bodies.getStyleClass().add(STYLE);
        names.getChildren().add(methodName);
        bodies.getChildren().add(methodBody);
        HBox entry = new HBox();
        entry.getChildren().add(names);
        entry.getChildren().add(bodies);
        entry.getStyleClass().add(STYLE);
        super.addEntry(entry);
    }
    private void setHeader() {
        Text heading1 = new Text("NAME");
        heading1.setWrappingWidth(250);
        Text heading2 = new Text("BODY");
        heading2.setWrappingWidth(250);
        header.getChildren().add(heading1);
        header.getChildren().add(heading2);
    }




}
