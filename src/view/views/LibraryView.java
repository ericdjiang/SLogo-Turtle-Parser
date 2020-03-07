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
    private final int SPACING = 250;

    public LibraryView(ResourceBundle resources) {
        super(resources);
        setHeader();

    }
    public void addMethod(String name, List<String> variables, String body) {
        Text methodName = new Text(name);
        Text methodBody = new Text(body);
        methodName.setWrappingWidth(SPACING);
        methodBody.setWrappingWidth(SPACING);
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
        Text heading1 = new Text(resources.getString("MethodName"));
        heading1.setWrappingWidth(SPACING);
        Text heading2 = new Text(resources.getString("MethodBody"));
        heading2.setWrappingWidth(SPACING);
        header.getChildren().add(heading1);
        header.getChildren().add(heading2);
    }
    public void updateLanguage(ResourceBundle resources) {
        this.resources = resources;
        header.getChildren().clear();
        setHeader();
    }




}
