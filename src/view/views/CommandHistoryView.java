package view.views;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CommandHistoryView extends ScrollPane {
    private VBox content = new VBox();
    private HBox header = new HBox();
    private VBox body = new VBox();
    private VBox lineNums =  new VBox();
    private VBox inputs = new VBox();
    private VBox outputs = new VBox();
    private List commandList;
    private int lineNum;

    public CommandHistoryView(ResourceBundle resources) {
        commandList = new ArrayList<Text>();
        setContent(content);
        lineNum = 1;
        header.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        Text i = new Text("INPUT");
        i.setWrappingWidth(250);
        Text o = new Text("OUTPUT");
        o.setWrappingWidth(250);
        header.getChildren().add(i);
        header.getChildren().add(o);
        content.getChildren().add(header);
        content.getChildren().add(body);
    }
    public void updateHistory(String input, double returnVal) {
        Text consoleInput = new Text(input);
        consoleInput.setFont(Font.font(10));
        commandList.add(input);
        consoleInput.setWrappingWidth(250); //remove magic number
        Text lineNumber = new Text(Integer.toString(lineNum));
        lineNumber.setFont(Font.font(10));
        Text consoleOutput = new Text(Double.toString(returnVal));
        consoleOutput.setWrappingWidth(250);
        consoleOutput.setFont(Font.font(10));
        VBox l =  new VBox();
        VBox i = new VBox();
        VBox o = new VBox();
        HBox entry = new HBox();
        l.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        i.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        o.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        entry.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        l.getChildren().add(lineNumber);
        i.getChildren().add(consoleInput);
        o.getChildren().add(consoleOutput);
        entry.getChildren().add(l);
        entry.getChildren().add(i);
        entry.getChildren().add(o);
        body.getChildren().add(entry);
        lineNum ++;
    }
    public void displayError(String input) {
        if (input != null) {
            Text error = new Text(input);
            Text lineNumber = new Text(Integer.toString(lineNum));
            error.setFill(Color.RED);
            this.lineNums.getChildren().add(lineNumber);
            this.inputs.getChildren().add(error);
            lineNum++;
        }
    }
    private void clearHistory() {
        lineNums.getChildren().clear();
        inputs.getChildren().clear();
        outputs.getChildren().clear();
    }
}
