package view.views;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;
//TODO separate into hboxs
public class VariableView extends InformationView {

    public VariableView(ResourceBundle resources) {
        super(resources);
        Text i = new Text("VARIABLE");
        i.setWrappingWidth(250);
        Text o = new Text("VALUE");
        o.setWrappingWidth(250);
        header.getChildren().add(i);
        header.getChildren().add(o);
    }
    public void addVariable(List<String> varName, List<String> varVal) {
        for (int i = 0; i < varName.size(); i ++) {
            Text name = new Text(varName.get(i));
            name.setFont(Font.font(10));
            name.setWrappingWidth(250);
            Text val = new Text(varVal.get(i));
            val.setFont(Font.font(10));
            val.setWrappingWidth(250);
            VBox variableNames = new VBox();
            VBox variableVals = new VBox();
            HBox entry = new HBox();
            variableNames.getChildren().add(name);
            variableVals.getChildren().add(val);
            entry.getChildren().add(variableNames);
            entry.getChildren().add(variableVals);
            variableNames.getStyleClass().add("vbox");
            variableVals.getStyleClass().add("vbox");
            entry.getStyleClass().add("vbox");
            super.addEntry(entry);
        }
    }




}
