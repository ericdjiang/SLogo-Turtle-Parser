package view;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.TurtleModel;
import parsing.Parser;

import javax.imageio.ImageIO;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ResourceBundle;

public class ControlPanel extends VBox {
    private ResourceBundle resources;
    private static final String RESOURCES = "resources/languages";
    private static final String DEFAULT_RESOURCE_FOLDER = "/" + RESOURCES + "/";
    private CommandHistoryView historyView;
    private Console console;
    private Button runButton;
    private Button clearButton;
    private Button turtleSwitchButton;
    private TurtleView turtleView;
    private Parser parser;
    private String myLanguage;
    private Controller c;

    public ControlPanel (ResourceBundle resources, CommandHistoryView historyView, Console console, TurtleView turtleView, String language, Controller c) {
        this.resources = resources;
        this.historyView = historyView;
        this.console = console;
        this.turtleView = turtleView;
        this.myLanguage = language;
        this.c = c;
        runButton = makeButton("Run", event -> {
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
        clearButton = makeButton("Clear", event -> clearConsole());
        turtleSwitchButton = makeButton("TurtleSelect", event -> switchTurtleImage());
        getChildren().add(runButton);
        getChildren().add(clearButton);
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
    public Button getTurtleSwitcher() {
        return this.turtleSwitchButton;
    }
    private void updateInputHistory(String commands){
        historyView.updateHistory(new Text(commands));
    }
    private void executeRun() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException {
        String commands = console.getText();
        resources.getBaseBundleName();
        parser = new Parser(commands, myLanguage, c.getModel());
        updateInputHistory(commands);
    }
    private void clearConsole() {
        console.clear();
    }
    public void updateLanguage(ResourceBundle resources, String language) {
        runButton.setText(resources.getString("Run"));
        clearButton.setText(resources.getString("Clear"));
        this.myLanguage = language;
    }
    private void switchTurtleImage() {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("src/resources/images"));
        Stage s = new Stage();
        File selected = fc.showOpenDialog(s);
        turtleView.setImage(selected.getName());
    }

}
