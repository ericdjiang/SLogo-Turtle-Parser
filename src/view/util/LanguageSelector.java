package view.util;

import javafx.scene.control.ComboBox;

import java.io.File;
import java.util.ResourceBundle;

public class LanguageSelector extends ComboBox<String> {
    private final String EXTENSION = ".properties";
    private static final String PROMPT_TEXT = "LanguageSelect";
    private static final String FILE_PATH = "src/resources/languages";
    private static final String BUNDLE_PATH = "resources/parsing.Unicode";

    public LanguageSelector(ResourceBundle resources) {
        setPromptText(resources.getString(PROMPT_TEXT));
        populateFromLanguageResources();
    }
    private void populateFromLanguageResources() {
        File folder = new File(FILE_PATH);
        ResourceBundle r = ResourceBundle.getBundle(BUNDLE_PATH);
        File[] listOfFiles = folder.listFiles();
        assert listOfFiles != null;
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile() && listOfFile.getName().contains(EXTENSION)) {
                this.getItems().add(r.getString(listOfFile.getName().split(EXTENSION)[0]));
            }
        }
    }
}
