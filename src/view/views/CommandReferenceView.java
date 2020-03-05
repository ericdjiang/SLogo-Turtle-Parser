package view.views;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

//TODO add more languages and refactor
public class CommandReferenceView extends InformationView {
    private List referenceList;
    private String myLanguage;

    public CommandReferenceView(ResourceBundle resources) throws IOException {
        super(resources);
        this.myLanguage = resources.getBaseBundleName();
        this.referenceList = new ArrayList<>();
        initializeReferences(myLanguage);
    }
    public void initializeReferences(String language) throws IOException {
        clear();
        referenceList.clear();
        HBox entry = new HBox();
        VBox functionNameList = new VBox();
        VBox functionParameterList = new VBox();
        VBox functionInstructionList = new VBox();
        VBox functionReturnList = new VBox();
        Text column1Title = new Text("NAME");
        Text column2Title = new Text("PARAMETERS");
        Text column3Title = new Text("DESCRIPTION");
        Text column4Title = new Text("RETURN VALUE");
        column1Title.setWrappingWidth(100);
        column2Title.setWrappingWidth(150);
        column3Title.setWrappingWidth(300);
        column4Title.setWrappingWidth(300);
        functionNameList.getStyleClass().add("vbox");
        functionParameterList.getStyleClass().add("vbox");
        functionInstructionList.getStyleClass().add("vbox");
        functionReturnList.getStyleClass().add("vbox");
        entry.getStyleClass().add("vbox");
        functionNameList.getChildren().add(column1Title);
        functionParameterList.getChildren().add(column2Title);
        functionInstructionList.getChildren().add(column3Title);
        functionReturnList.getChildren().add(column4Title);
        createEntry(functionNameList, functionParameterList, functionInstructionList, functionReturnList, entry);
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
            functionNameList.getStyleClass().add("vbox");
            functionParameterList.getStyleClass().add("vbox");
            functionInstructionList.getStyleClass().add("vbox");
            functionReturnList.getStyleClass().add("vbox");
            functionNameList.getChildren().add(t1);
            functionParameterList.getChildren().add(t2);
            functionInstructionList.getChildren().add(t3);
            functionReturnList.getChildren().add(t4);
            createEntry(functionNameList, functionParameterList, functionInstructionList, functionReturnList, entry);
            super.addEntry(entry);


//            referenceList.add(s);
        }

//        for (Object o : referenceList) {
//           Text text = new Text((String) o);
//            content.getChildren().add(text);
//        }

    }
    private void createEntry(Node col1, Node col2, Node col3, Node col4, HBox entry) {
        entry.getChildren().add(col1);
        entry.getChildren().add(col2);
        entry.getChildren().add(col3);
        entry.getChildren().add(col4);
        entry.getStyleClass().add("vbox");
    }

}
