package view;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import parsing.Parser;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ResourceBundle;

public class UserInterface {

    private static final int HEIGHT = 600;
    private static final int WIDTH = 850;

    private static final String RESOURCES = "resources/languages";
    private static final String DEFAULT_RESOURCE_PACKAGE = RESOURCES + ".";
    private static final String STYLESHEET = "resources/stylesheets/default.css";

    private ResourceBundle myResources;
    private HBox customizationPanel = new HBox();
    private HBox inputPanel = new HBox();
    private BorderPane mainView = new BorderPane();
    private BorderPane mainFrame = new BorderPane();
    private ColorPicker colorPicker = new ColorPicker();
    private ViewSwitchText historySwitchText;
    private ViewSwitchText referenceSwitchText;
    private ViewSwitchText variableSwitchText;
    private TurtleWindow turtleWindow;
    private Parser parser;
    private CommandReferenceView referenceView;
    private CommandHistoryView historyView;
    private VariableView variableView;
    private Console commandPrompt;
    private LanguageSelector languageSelector;
    private ControlPanel controlPanel;
    public CommandHistoryWindow historyWindow;
    private CommandReferenceWindow referenceWindow;
    private VariableWindow variableWindow;

    private String myLanguage;

    public UserInterface(Stage stage, String language, TurtleWindow turtleWindow, Controller c) throws IOException, InvocationTargetException, IllegalAccessException {
        this.myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
        this.myLanguage = language;
        this.turtleWindow = turtleWindow;
        this.referenceView = new CommandReferenceView(language);
        this.commandPrompt = new Console(myResources);
        this.historyView = new CommandHistoryView(myResources);
        this.variableView = new VariableView(myResources);
        this.languageSelector = new LanguageSelector(myResources);
        this.controlPanel = new ControlPanel(myResources, historyView, commandPrompt, c.getView(), myLanguage, c);
        stage.setTitle(myResources.getString("Title"));
        //this.parser = new Parser();
    }
    public Scene setupUI() throws IOException {
        historySwitchText = new ViewSwitchText(myResources.getString("HistoryWindow"));
        referenceSwitchText = new ViewSwitchText(myResources.getString("CommandWindow"));
        variableSwitchText = new ViewSwitchText(myResources.getString("VariableWindow"));

        historyWindow = new CommandHistoryWindow(historySwitchText, referenceSwitchText, variableSwitchText, historyView);

        customizationPanel.getChildren().add(languageSelector);
        customizationPanel.getChildren().add(colorPicker);
        Button b = controlPanel.getTurtleSwitcher();
        customizationPanel.getChildren().add(b);
        b.getStyleClass().add("turtleswitch");

        colorPicker.setOnAction(event -> setBackgroundColor(turtleWindow));
        languageSelector.setOnAction(event -> {
            try {
                updateLanguage();
            } catch (IOException e) {
//                    e.printStackTrace();
            }
        });
        historySwitchText.setOnMouseClicked(event -> setHistoryWindow());
        referenceSwitchText.setOnMouseClicked(event -> {
            setCommandsWindow();
        });
        variableSwitchText.setOnMouseClicked(event -> setVariableWindow());

        inputPanel.getChildren().add(commandPrompt);
        inputPanel.getChildren().add(controlPanel);

        mainView.setBottom(inputPanel);
        mainView.setCenter(turtleWindow);
        mainView.setTop(customizationPanel);
        mainFrame.setCenter(mainView);
        mainFrame.setRight(historyWindow);
        Scene myScene = new Scene(mainFrame, WIDTH, HEIGHT);
        myScene.getStylesheets().add(STYLESHEET);
        return myScene;
    }
    private void setBackgroundColor(Pane turtleView) {
        turtleView.setBackground(new Background(new BackgroundFill(colorPicker.getValue(), CornerRadii.EMPTY, Insets.EMPTY)));
    }
    private void updateLanguage() throws IOException {
        ResourceBundle r = ResourceBundle.getBundle("resources/parsing.Unicode");
        myLanguage = r.getString(languageSelector.getValue());
        //parser.addPatterns(myLanguage);
        System.out.println(myLanguage);
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + myLanguage);
        commandPrompt.updateLanguage(myResources);
        referenceView.initializeReferences(myLanguage);
        controlPanel.updateLanguage(myResources, myLanguage);
        historySwitchText.updateLanguage(myResources.getString("HistoryWindow"));
        referenceSwitchText.updateLanguage(myResources.getString("CommandWindow"));
        variableSwitchText.updateLanguage(myResources.getString("VariableWindow"));
    }
    //probably refactor windows into another class and call a contructor to set right
    private void setHistoryWindow() {
        mainFrame.getChildren().remove(mainFrame.getRight());
        historyWindow = new CommandHistoryWindow(historySwitchText, referenceSwitchText, variableSwitchText, historyView);
        mainFrame.setRight(historyWindow);
    }
    private void setCommandsWindow() {
        mainFrame.getChildren().remove(mainFrame.getRight());
        referenceWindow = new CommandReferenceWindow(historySwitchText, referenceSwitchText, variableSwitchText, referenceView);
        mainFrame.setRight(referenceWindow);
    }
    private void setVariableWindow() {
        mainFrame.getChildren().remove(mainFrame.getRight());
        variableWindow = new VariableWindow(historySwitchText, referenceSwitchText, variableSwitchText, variableView);
        mainFrame.setRight(variableWindow);
    }
}




