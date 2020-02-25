package View;

import javafx.scene.control.ComboBox;

import java.io.File;
import java.util.ResourceBundle;

public class LanguageSelector extends ComboBox<String> {
    private final String EXTENSION = ".properties";

    public LanguageSelector(ResourceBundle resources) {
        setPromptText(resources.getString("LanguageSelect"));
        populateFromLanguageResources();
    }
    private void populateFromLanguageResources() {
        File folder = new File("src/resources/languages");
        ResourceBundle r = ResourceBundle.getBundle("resources/parsing.Unicode");
        File[] listOfFiles = folder.listFiles();
        assert listOfFiles != null;
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile() && listOfFile.getName().contains(EXTENSION)) {
                this.getItems().add(r.getString(listOfFile.getName().split(EXTENSION)[0]));
            }
        }
    }
}
