package View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import parsing.Parser;

import javax.imageio.ImageIO;
import java.lang.reflect.InvocationTargetException;
import java.util.ResourceBundle;

public class ControlPanel {
    private ResourceBundle resources;
    private static final String RESOURCES = "resources/languages";
    private static final String DEFAULT_RESOURCE_FOLDER = "/" + RESOURCES + "/";
    private CommandHistoryView historyView;
    private Console console;
    private Button runButton;
    private Button clearButton;

    public ControlPanel (ResourceBundle resources, CommandHistoryView historyView, Console console) {
        this.resources = resources;
        this.historyView = historyView;
        this.console = console;
        runButton = makeButton(resources.getString("Run"), event -> {
            try {
                executeRun();
            } catch (InvocationTargetException e) {
                //e.printStackTrace();
            } catch (IllegalAccessException e) {
                //e.printStackTrace();
            } catch (NoSuchMethodException e) {
                //e.printStackTrace();
            } catch (InstantiationException e) {
                //e.printStackTrace();
            } catch (ClassNotFoundException e) {
                //e.printStackTrace();
            }
        });
        clearButton = makeButton(resources.getString("Clear"), event -> clearConsole());

    }
    public Button getRunButton() {
        return this.runButton;
    }
    public Button getClearButton() {
        return this.clearButton;
    }
    private Button makeButton(String property, EventHandler<ActionEvent> handler) {
        // represent all supported image suffixes
        final String IMAGEFILE_SUFFIXES = String
                .format(".*\\.(%s)", String.join("|", ImageIO.getReaderFileSuffixes()));
        Button result = new Button();
        String label = resources.getString(property);
        if (label.matches(IMAGEFILE_SUFFIXES)) {
            result.setGraphic(new ImageView(
                    new Image(getClass().getResourceAsStream(DEFAULT_RESOURCE_FOLDER + label))));
        } else {
            result.setText(label);
        }
        result.setOnAction(handler);
        return result;
    }
    private void updateInputHistory(String commands){
        historyView.updateHistory(new Text(commands));
    }
    private void executeRun() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException {
        String commands = console.getText();
        //parser = new Parser(commands, myLanguage);
        //turtleWindow.setTurtleXPos(turtleWindow.getTurtleXPos() + 50);
        //turtleWindow.setTurtleRotation(turtleWindow.getTurtleRotation() + 15);
        updateInputHistory(commands);
    }
    private void clearConsole() {
        console.clear();
    }
    public void updateLanguage(ResourceBundle resources) {
        runButton.setText(resources.getString("Run"));
        clearButton.setText(resources.getString("Clear"));
    }
}
