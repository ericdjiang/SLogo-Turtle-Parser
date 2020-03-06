package view.views;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//TODO add more languages and refactor
public class CommandReferenceView extends ScrollPane {
    private VBox content = new VBox();
    private HBox header = new HBox();
    private VBox body = new VBox();
    private List referenceList;
    private String myLanguage;

    public CommandReferenceView(String language) throws IOException {
        this.myLanguage = language;
        this.referenceList = new ArrayList<>();
        setContent(content);
        initializeReferences(myLanguage);
        header.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
//        header.getChildren().add(new Text("FUNCTION NAME"));
//        header.getChildren().add(new Text("PARAMETERS"));
//        header.getChildren().add(new Text("DESCRIPTION"));
//        header.getChildren().add(new Text("RETURN VALUE"));
        content.getChildren().add(header);
        content.getChildren().add(body);
    }
    public void initializeReferences(String language) throws IOException {
        content.getChildren().clear();
        referenceList.clear();
        HBox entry = new HBox();
        VBox functionNameList = new VBox();
        VBox functionParameterList = new VBox();
        VBox functionInstructionList = new VBox();
        VBox functionReturnList = new VBox();
        Text h1 = new Text("NAME");
        Text h2 = new Text("PARAMETERS");
        Text h3 = new Text("DESCRIPTION");
        Text h4 = new Text("RETURN VALUE");
        h1.setWrappingWidth(100);
        h2.setWrappingWidth(150);
        h3.setWrappingWidth(300);
        h4.setWrappingWidth(300);
        functionNameList.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        functionParameterList.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        functionInstructionList.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        functionReturnList.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        entry.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        functionNameList.getChildren().add(h1);
        functionParameterList.getChildren().add(h2);
        functionInstructionList.getChildren().add(h3);
        functionReturnList.getChildren().add(h4);
        entry.getChildren().add(functionNameList);
        entry.getChildren().add(functionParameterList);
        entry.getChildren().add(functionInstructionList);
        entry.getChildren().add(functionReturnList);
        header.getChildren().add(entry);

        Scanner fileReader = new Scanner(new File("src/resources/parsing/EnglishHelp.properties"));
        while (fileReader.hasNextLine()) {
            String s = fileReader.nextLine();
            String[] l = s.split(",");
            Text t1 = new Text(l[0]);
            Text t2 = new Text(l[1]);
            Text t3 = new Text(l[2]);
            Text t4 = new Text(l[3]);
            t1.setFont(Font.font(10));
            t2.setFont(Font.font(10));
            t3.setFont(Font.font(10));
            t4.setFont(Font.font(10));
            t1.setWrappingWidth(100);
            t2.setWrappingWidth(150);
            t3.setWrappingWidth(300);
            t4.setWrappingWidth(300);
             entry = new HBox();
             functionNameList = new VBox();
             functionParameterList = new VBox();
             functionInstructionList = new VBox();
             functionReturnList = new VBox();
            functionNameList.setBorder(new Border(new BorderStroke(Color.BLACK,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            functionParameterList.setBorder(new Border(new BorderStroke(Color.BLACK,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            functionInstructionList.setBorder(new Border(new BorderStroke(Color.BLACK,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            functionReturnList.setBorder(new Border(new BorderStroke(Color.BLACK,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            functionNameList.getChildren().add(t1);
            functionParameterList.getChildren().add(t2);
            functionInstructionList.getChildren().add(t3);
            functionReturnList.getChildren().add(t4);
            entry.getChildren().add(functionNameList);
            entry.getChildren().add(functionParameterList);
            entry.getChildren().add(functionInstructionList);
            entry.getChildren().add(functionReturnList);
            entry.setBorder(new Border(new BorderStroke(Color.BLACK,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            body.getChildren().add(entry);


//            referenceList.add(s);
        }

//        for (Object o : referenceList) {
//            Text text = new Text((String) o);
//            content.getChildren().add(text);
//        }

    }

}
