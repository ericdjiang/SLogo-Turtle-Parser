package view;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ResourceBundle;

public class UserInterface {

    private static final int HEIGHT = 576;
    private static final int WIDTH = 1024;

    private static final String RESOURCES = "resources/languages";
    private static final String DEFAULT_RESOURCE_PACKAGE = RESOURCES + ".";
    private static final String STYLESHEET = "resources/stylesheets/default.css";

    private ResourceBundle myResources;
    private HBox customizationPanel = new HBox();
    private HBox inputPanel = new HBox();
    private BorderPane mainView = new BorderPane();
    private BorderPane mainFrame = new BorderPane();
    private ColorPicker colorPicker = new ColorPicker();
    private ColorPicker penColorPicker = new ColorPicker();
    private ViewSwitchText historySwitchText;
    private ViewSwitchText referenceSwitchText;
    private ViewSwitchText variableSwitchText;
    private TurtleWindow turtleWindow;
    private CommandReferenceView referenceView;
    private CommandHistoryView historyView;
    private VariableView variableView;
    private ConsoleView commandPrompt;
    private LanguageSelector languageSelector;
    private ControlPanel controlPanel;
    public CommandHistoryWindow historyWindow;
    private CommandReferenceWindow referenceWindow;
    private VariableWindow variableWindow;
    private Controller controller;
    private Pen pen;
    private String myLanguage;
    private final HBox console = new HBox();

    public UserInterface(Stage stage, String language, TurtleWindow turtleWindow, Controller c) throws IOException, InvocationTargetException, IllegalAccessException {
        this.myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
        this.myLanguage = language;
        this.turtleWindow = turtleWindow;
        this.referenceView = new CommandReferenceView(language);
        this.commandPrompt = new ConsoleView(myResources);
        this.historyView = new CommandHistoryView(myResources);
        this.variableView = new VariableView(myResources);
        this.languageSelector = new LanguageSelector(myResources);
        this.controlPanel = new ControlPanel(myResources, historyView, commandPrompt, c.getView(), myLanguage, c, c.getConsoleModel(), c.getModel(), variableView);
        this.controller = c;
        this.pen = c.getPen();
        stage.setTitle(myResources.getString("Title"));
    }
    public Scene setupUI() {
        historySwitchText = new ViewSwitchText(myResources.getString("HistoryWindow"));
        referenceSwitchText = new ViewSwitchText(myResources.getString("CommandWindow"));
        variableSwitchText = new ViewSwitchText(myResources.getString("VariableWindow"));

        historyWindow = new CommandHistoryWindow(historySwitchText, referenceSwitchText, variableSwitchText, historyView);
        customizationPanel.getChildren().add(languageSelector);
        customizationPanel.getChildren().add(colorPicker);
        penColorPicker.setValue(Color.BLACK);
        customizationPanel.getChildren().add(penColorPicker);
        //FIXME refactor button
        Button b = controlPanel.getTurtleSwitcher();
        customizationPanel.getChildren().add(b);
        b.getStyleClass().add("turtleswitch");
        penColorPicker.setOnAction(event -> setPenColor());
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
        setFooter();
        inputPanel.getChildren().add(console);
        inputPanel.getChildren().add(controlPanel);

        mainView.setBottom(inputPanel);
        turtleWindow.getStyleClass().add("turtlewindow");
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
    private void setPenColor() {
        pen.setColor(penColorPicker.getValue());
    }
    private void updateLanguage() throws IOException {
        ResourceBundle r = ResourceBundle.getBundle("resources/parsing.Unicode");
        myLanguage = r.getString(languageSelector.getValue());
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + myLanguage);
        commandPrompt.updateLanguage(myResources);
        referenceView.initializeReferences(myLanguage);
        controlPanel.updateLanguage(myResources, myLanguage);
        historySwitchText.updateLanguage(myResources.getString("HistoryWindow"));
        referenceSwitchText.updateLanguage(myResources.getString("CommandWindow"));
        variableSwitchText.updateLanguage(myResources.getString("VariableWindow"));
    }
    private void setFooter() {
        console.getChildren().add(commandPrompt.getPrompt());
        console.getChildren().add(commandPrompt);
    }
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




