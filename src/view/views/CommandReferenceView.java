package view.views;

import javafx.scene.Node;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class CommandReferenceView extends InformationView {
    private static final String STYLE = "vbox";
    private List<String> referenceList;
    private String myLanguage;
    private int index;

    public CommandReferenceView(ResourceBundle resources) throws IOException {
        super(resources);
        this.myLanguage = resources.getBaseBundleName();
        this.referenceList = new ArrayList<>();
        initializeReferences(myLanguage);
    }
    public void initializeReferences(String language) throws IOException {
        clear();
        setHeader();
        retrieveReferenceInfo(language);
        for (int i = 0; i < referenceList.size()/4; i++) {
            Text name = new Text(referenceList.get(index));
            Text param = new Text(referenceList.get(index+1));
            Text info = new Text(referenceList.get(index+2));
            Text ret = new Text(referenceList.get(index+3));
            name.setWrappingWidth(100);
            param.setWrappingWidth(150);
            info.setWrappingWidth(300);
            ret.setWrappingWidth(300);
            VBox functionNameList = new VBox();
            VBox functionParameterList = new VBox();
            VBox functionInstructionList = new VBox();
            VBox functionReturnList = new VBox();
            functionNameList.getStyleClass().add(STYLE);
            functionParameterList.getStyleClass().add(STYLE);
            functionInstructionList.getStyleClass().add(STYLE);
            functionReturnList.getStyleClass().add(STYLE);
            functionNameList.getChildren().add(name);
            functionParameterList.getChildren().add(param);
            functionInstructionList.getChildren().add(info);
            functionReturnList.getChildren().add(ret);
            super.addEntry(createEntry(functionNameList, functionParameterList, functionInstructionList, functionReturnList));
            index += 4;
        }
    }
    private void retrieveReferenceInfo(String language) throws FileNotFoundException {
        Scanner fileReader = new Scanner(new File("src/resources/parsing/EnglishHelp.properties"));
        while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();
            String[] parsedInfo = line.split(",");
            referenceList.addAll(Arrays.asList(parsedInfo));
        }
    }
    private void setHeader() {
        VBox functionNameList = new VBox();
        VBox functionParameterList = new VBox();
        VBox functionInstructionList = new VBox();
        VBox functionReturnList = new VBox();
        Text column1Title = new Text(resources.getString("ReferenceName"));
        Text column2Title = new Text(resources.getString("ReferenceParams"));
        Text column3Title = new Text(resources.getString("ReferenceInfo"));
        Text column4Title = new Text(resources.getString("ReferenceRet"));
        column1Title.setWrappingWidth(100);
        column2Title.setWrappingWidth(150);
        column3Title.setWrappingWidth(300);
        column4Title.setWrappingWidth(300);
        functionNameList.getStyleClass().add(STYLE);
        functionParameterList.getStyleClass().add(STYLE);
        functionInstructionList.getStyleClass().add(STYLE);
        functionReturnList.getStyleClass().add(STYLE);
        functionNameList.getChildren().add(column1Title);
        functionParameterList.getChildren().add(column2Title);
        functionInstructionList.getChildren().add(column3Title);
        functionReturnList.getChildren().add(column4Title);
        header.getChildren().add(createEntry(functionNameList, functionParameterList, functionInstructionList, functionReturnList));
    }
    private Node createEntry(Node col1, Node col2, Node col3, Node col4) {
        HBox entry = new HBox();
        entry.getChildren().add(col1);
        entry.getChildren().add(col2);
        entry.getChildren().add(col3);
        entry.getChildren().add(col4);
        entry.getStyleClass().add(STYLE);
        return entry;
    }

    @Override
    protected void clear() {
        index = 0;
        super.clear();
    }
}
