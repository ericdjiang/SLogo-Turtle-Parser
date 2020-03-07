package view.views;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

public class VariableView extends InformationView {
    private static final String STYLE = "vbox";
    private boolean changedVariables = false;

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
            name.setOnMouseClicked(e->
                handleTextPressed(name,"Variable"));
            val.setOnMouseClicked(e->handleTextPressed(val,"Value"));
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
        Text heading1 = new Text(resources.getString("VariableName"));
        heading1.setWrappingWidth(250);
        Text heading2 = new Text(resources.getString("VariableValue"));
        heading2.setWrappingWidth(250);
        header.getChildren().add(heading1);
        header.getChildren().add(heading2);
    }

    private void handleTextPressed(Text text, String type){
        TextArea ta = new TextArea();
        ta.setPromptText("Change " +type+ " Name");
        Stage s = new Stage();
        s.show();
        s.setScene(new Scene(ta));
        s.setAlwaysOnTop(true);
        ta.setOnMouseClicked(f->{
            s.hide();
            if(!ta.getText().equals("")){
                //FIXME: send error if not right type
                text.setText(ta.getText());
                changedVariables = true;
            }
        });
        ta.setOnKeyPressed(k->{
            if (k.getCode() == KeyCode.ENTER){
                s.hide();
                if(!ta.getText().equals("")){
                    text.setText(ta.getText());
                    changedVariables = true;
                }
            }
        });
    }
    public boolean isChangedVariables(){
        return changedVariables;
    }
    public void setChangedVariablesFalse(){
        changedVariables = false;
    }
    public void updateLanguage(ResourceBundle resources) {
        this.resources = resources;
        header.getChildren().clear();
        setHeader();
    }
}

