package view.util;

import controller.Controller;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.*;

import parsing.Parser;
import view.views.*;

import javax.imageio.ImageIO;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ControlPanel extends VBox {
    private ResourceBundle resources;
    private static final String RESOURCES = "resources/languages";
    private static final String DEFAULT_RESOURCE_FOLDER = "/" + RESOURCES + "/";
    private static final String SAVEDCOMMANDSFILE = "data/SavedCommands.txt";
    private static final String UPLOADFILE = "UploadFile";
    private static final String RUN = "Run";
    private static final String CLEAR = "Clear";
    private static final String TURTLESELECT = "TurtleSelect";
    private static final String DASH = "ToggleDash";
    private CommandHistoryView historyView;
    private ConsoleView consoleView;
    private Button runButton;
    private Button clearButton;
    private Button uploadButton;
    private Button turtleSwitchButton;
    private Parser parser;
    private String myLanguage;

    private TurtleContainer turtleContainer;
    private Controller c;


    public ControlPanel(ResourceBundle resources, ConsoleView consoleView, TurtleContainer turtlecontainer, Controller c) {
        this.resources = resources;
        this.consoleView = consoleView;
        this.c = c;
        uploadButton = makeButton(UPLOADFILE, event-> openFileChooser());
        runButton = makeButton(RUN, event -> {
        executeRun();
        });
        clearButton = makeButton(CLEAR, event -> clearConsole());
        turtleSwitchButton = makeButton(TURTLESELECT, event -> {
            for(TurtleView turtleView : turtleContainer.getTurtleViews()){
                turtleView.switchTurtleImage();
            }
        });
        getChildren().add(runButton);
        getChildren().add(clearButton);
        getChildren().add(uploadButton);
        turtleContainer = turtlecontainer;
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

    private void executeRun(){
        String commands = consoleView.getText();
        resources.getBaseBundleName();
        c.createParser(commands);
        c.updateInputHistory(commands);
        c.updateVariableView();
        c.updateLibraryView();
        //saveToFile(commands);
        // FIXME: Find a way to only save some commands not all of them
    }


    private void clearConsole() {
        consoleView.clear();
    }
    public void updateLanguage(ResourceBundle resources, String language) {
        runButton.setText(resources.getString(RUN));
        clearButton.setText(resources.getString(CLEAR));
        uploadButton.setText(resources.getString(UPLOADFILE));

        this.myLanguage = language;
    }
    public void sendColorToController(Paint color) {
        c.setPenColor(color);
    }

    private void addUploadedText(File file){
        try {
            Scanner s = new Scanner(file);
            while (s.hasNextLine()){
                consoleView.appendText(s.nextLine());
                consoleView.appendText("\n");
            }
            executeRun();
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
        }
    }
    private void openFileChooser(){
        FileChooser fileChooser = new FileChooser();
        Stage s = new Stage();
        File fileChosen = fileChooser.showOpenDialog(s);
        if(fileChosen != null){
            addUploadedText(fileChosen);
        }
    }

    private void saveToFile(String text){
        File file = new File(SAVEDCOMMANDSFILE);
        try {
            FileWriter writer = new FileWriter(file,false);
            BufferedWriter br = new BufferedWriter(writer);
            br.write(text);
            br.close();
            writer.close();
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }
}
