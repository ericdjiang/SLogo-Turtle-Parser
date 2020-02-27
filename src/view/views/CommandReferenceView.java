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
    private HBox content = new HBox();
    private VBox functionNameList = new VBox();
    private VBox functionParameterList = new VBox();
    private VBox functionInstructionList = new VBox();
    private VBox functionReturnList = new VBox();
    private List referenceList;
    private String myLanguage;

    public CommandReferenceView(String language) throws IOException {
        this.myLanguage = language;
        this.referenceList = new ArrayList<>();
        setContent(content);
        initializeReferences(myLanguage);
        functionNameList.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        functionParameterList.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        functionInstructionList.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        functionReturnList.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

    }
    public void initializeReferences(String language) throws IOException {
        content.getChildren().clear();
        referenceList.clear();
        functionNameList.getChildren().add(new Text("FUNCTION NAME"));
        functionParameterList.getChildren().add(new Text("PARAMETERS"));
        functionInstructionList.getChildren().add(new Text("DESCRIPTION"));
        functionReturnList.getChildren().add(new Text("RETURN VALUE"));
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
            t3.setWrappingWidth(300);
            functionNameList.getChildren().add(t1);
            functionParameterList.getChildren().add(t2);
            functionInstructionList.getChildren().add(t3);
            functionReturnList.getChildren().add(t4);

//            referenceList.add(s);
        }
        content.getChildren().add(functionNameList);
        content.getChildren().add(functionParameterList);
        content.getChildren().add(functionInstructionList);
        content.getChildren().add(functionReturnList);
//        for (Object o : referenceList) {
//            Text text = new Text((String) o);
//            content.getChildren().add(text);
//        }

    }

}
