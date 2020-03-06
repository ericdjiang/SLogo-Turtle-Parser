package view.views;

import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

public class VariableView extends InformationView {
    private static final String STYLE = "vbox";

    public VariableView(ResourceBundle resources) {
        super(resources);
        setHeader();
    }
    public void addVariable(List<String> varName, List<String> varVal) {
        for (int i = 0; i < varName.size(); i ++) {
            VBox variableNames = new VBox();
            VBox variableVals = new VBox();
            Text name = new Text(varName.get(i));
            Text val = new Text(varVal.get(i));
            name.setWrappingWidth(250);
            val.setWrappingWidth(250);
            variableNames.getChildren().add(name);
            variableVals.getChildren().add(val);
            createAndAddEntry(variableNames, variableVals);
        }
    }
    private void createAndAddEntry(Node names, Node vals) {
        HBox entry = new HBox();
        entry.getChildren().add(names);
        entry.getChildren().add(vals);
        names.getStyleClass().add(STYLE);
        vals.getStyleClass().add(STYLE);
        entry.getStyleClass().add(STYLE);
        super.addEntry(entry);
    }
    private void setHeader() {
        Text heading1 = new Text("VARIABLE");
        heading1.setWrappingWidth(250);
        Text heading2 = new Text("VALUE");
        heading2.setWrappingWidth(250);
        header.getChildren().add(heading1);
        header.getChildren().add(heading2);
    }
}
