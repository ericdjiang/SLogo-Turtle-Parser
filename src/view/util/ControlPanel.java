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
import javafx.scene.text.Text;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.ConsoleModel;

import model.MethodModel;
import model.TurtleModel;
import model.VariableModel;

import parsing.Parser;
import view.views.TurtleView;
import view.views.VariableView;
import view.views.CommandHistoryView;
import view.views.ConsoleView;

import javax.imageio.ImageIO;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ControlPanel extends VBox {
    private ResourceBundle resources;
    private static final String RESOURCES = "resources/languages";
    private static final String DEFAULT_RESOURCE_FOLDER = "/" + RESOURCES + "/";
    private CommandHistoryView historyView;
    private ConsoleView consoleView;
    private Button runButton;
    private Button clearButton;
    private Button uploadButton;
    private Button turtleSwitchButton;
    private TurtleView turtleView;
    private Parser parser;
    private String myLanguage;
    private TurtleModel model;
    private Controller c;
    private ConsoleModel cm;

    private VariableModel variableModel;
    private VariableView variableView;

    private Map<String, MethodModel> methodModels;



    public ControlPanel(ResourceBundle resources, CommandHistoryView historyView, ConsoleView consoleView, TurtleView turtleView, String language, Controller c, ConsoleModel cm, TurtleModel model, VariableView variableView) {
        this.resources = resources;
        this.historyView = historyView;
        this.consoleView = consoleView;
        this.turtleView = turtleView;
        this.myLanguage = language;
        this.model = model;
        this.variableView = variableView;
        this.cm = cm;
        this.c = c;
        this.variableModel = new VariableModel();
        this.methodModels = new HashMap<>();
        uploadButton = makeButton("UploadFile", event-> openFileChooser());
        runButton = makeButton("Run", event -> {
        executeRun();
        });
        clearButton = makeButton("Clear", event -> clearConsole());
        turtleSwitchButton = makeButton("TurtleSelect", event -> turtleView.switchTurtleImage());
        getChildren().add(runButton);
        getChildren().add(clearButton);
        getChildren().add(uploadButton);
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
        historyView.updateHistory("\tInput: " + commands + "; Output: " + c.getConsoleModel().getReturnVal());
        historyView.displayError(c.getConsoleModel().getErrorMessage());
        c.getConsoleModel().setErrorMessage(null);
    }

    private void executeRun(){
        String commands = consoleView.getText();
        resources.getBaseBundleName();
        parser = new Parser(commands, myLanguage, model, variableModel, c.getConsoleModel(), methodModels);
        updateInputHistory(commands);
        updateVariableView();
        saveToFile(commands);
    }
    private void updateVariableView() {
        Text t = new Text(variableModel.getVariable());
        if (variableModel.newVarAdded()) {
            variableView.addVariable(t);
        }
        variableModel.varReceived();
    }
    private void clearConsole() {
        consoleView.clear();
    }
    public void updateLanguage(ResourceBundle resources, String language) {
        runButton.setText(resources.getString("Run"));
        clearButton.setText(resources.getString("Clear"));
        this.myLanguage = language;
    }

    public void sendErrorToConsoleModel(String errorMessage){
        cm.setErrorMessage(errorMessage);
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
        File file = new File("data/SavedCommands.txt");
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
