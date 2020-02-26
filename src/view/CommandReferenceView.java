package view;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommandReferenceView extends ScrollPane {
    private VBox content = new VBox();
    private List referenceList;
    private String myLanguage;

    public CommandReferenceView(String language) throws IOException {
        this.myLanguage = language;
        this.referenceList = new ArrayList<>();
        setContent(content);
        initializeReferences(myLanguage);
    }
    public void initializeReferences(String language) throws IOException {
        content.getChildren().clear();
        referenceList.clear();
        Scanner fileReader = new Scanner(new File("src/resources/languages/" + language + ".properties"));
        while (fileReader.hasNextLine()) {
            String s = fileReader.nextLine();
            if (s.contains("Run")) {
                fileReader.reset();
                break;
            }
            if (! s.equals("#")) {
                referenceList.add(s);
            }

        }
        for (Object o : referenceList) {
            Text text = new Text((String) o);
            content.getChildren().add(text);
        }

    }

}
