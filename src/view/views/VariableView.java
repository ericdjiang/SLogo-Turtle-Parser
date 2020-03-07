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
import java.util.*;

public class VariableView extends InformationView {
    private static final String STYLE = "vbox";
    private boolean changedVariables = false;
    private List<String> myVariables;
    private List<String> myValues;

    public VariableView(ResourceBundle resources) {
        super(resources);
        setHeader();
        myVariables = new ArrayList<>();
        myValues = new ArrayList<>();
    }
    public void addVariable(List<String> varName, List<String> varVal) {
        for (int i = 0; i < varName.size(); i ++) {
            VBox variableNames = new VBox();
            VBox variableVals = new VBox();
            // Throw error here
            Text name = new VariableText(varName.get(i),myVariables.size());
            Text val = new VariableText(varVal.get(i),myVariables.size());
            myVariables.add(varName.get(i));
            myValues.add(varName.get(i));
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
        Text heading1 = new Text("VARIABLE");
        heading1.setWrappingWidth(250);
        Text heading2 = new Text("VALUE");
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
        ta.setOnMouseExited(f-> hideAndChangeText(s,ta,text,type));
        ta.setOnKeyPressed(k->{
            if (k.getCode() == KeyCode.ENTER){
                hideAndChangeText(s,ta,text,type);
            }
        });
    }
    public boolean isChangedVariables(){
        return changedVariables;
    }
    public void setChangedVariablesFalse(){
        changedVariables = false;
    }
    private void hideAndChangeText(Stage s, TextArea ta, Text text, String type){
        s.hide();
        if(!ta.getText().equals("")){
            text.setText(ta.getText());
            changedVariables = true;
            updateMap(type,ta.getText(),((VariableText)text).getIndex());
        }
    }
    private void updateMap(String type, String text,int index){
        switch (type){
            case "Variable":
                myVariables.set(index,text);
                break;
            case "Value":
                myValues.set(index,text);
                try {
                    double d = Double.parseDouble(text);
                }
                catch (NumberFormatException e){
                    System.out.println("ERROR WRONG TYPE");
                }
                break;
        }
    }
    public List<String> geVariables(){
        return myVariables;
    }
    public List<String> getValues(){
        return myValues;
    }
}

