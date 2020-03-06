package view.layout;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.TurtleContainer;
import view.util.ColorSelector;
import view.views.VariableView;
import view.util.ControlPanel;
import view.util.LanguageSelector;
import view.util.Pen;
import view.views.CommandHistoryView;
import view.views.CommandReferenceView;
import view.views.ConsoleView;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ResourceBundle;

public class UserInterface {

    private static final int HEIGHT = 576;
    private static final int WIDTH = 1024;
    private static final String RESOURCES = "resources/languages";
    private static final String DEFAULT_RESOURCE_FOLDER = "/" + RESOURCES + "/";
    private static final String DEFAULT_RESOURCE_PACKAGE = RESOURCES + ".";
    private static final String STYLESHEET = "resources/stylesheets/default.css";

    private ResourceBundle myResources;
    private HBox customizationPanel = new HBox();
    private HBox inputPanel = new HBox();
    private BorderPane mainView = new BorderPane();
    private BorderPane mainFrame = new BorderPane();
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
    public InformationWindow historyWindow;
    private InformationWindow referenceWindow;
    private InformationWindow variableWindow;
    private Controller controller;
    private Pen pen;
    private String myLanguage;
    private final HBox console = new HBox();
    private Button turtleButton;
    private ColorSelector backgroundColorSelector;
    private ColorSelector penColorSelector;

    public UserInterface(Stage stage, String language, TurtleWindow turtleWindow, Controller c, TurtleContainer turtleContainer) throws IOException, InvocationTargetException, IllegalAccessException {
        this.myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
        this.myLanguage = language;
        this.turtleWindow = turtleWindow;
        this.referenceView = new CommandReferenceView(myResources);
        this.commandPrompt = new ConsoleView(myResources);
        this.historyView = new CommandHistoryView(myResources);
        this.variableView = new VariableView(myResources);
        this.languageSelector = new LanguageSelector(myResources);
        this.controlPanel = new ControlPanel(myResources, historyView, commandPrompt, myLanguage, c, c.getConsoleModel(), variableView,turtleContainer );
        this.controller = c;
        this.pen = c.getPen();
        this.backgroundColorSelector = new ColorSelector(myResources.getString("ChooseBackground"));
        this.penColorSelector = new ColorSelector(myResources.getString("ChoosePen"));
        stage.setTitle(myResources.getString("Title"));
    }
    public Scene setupUI() {
        historySwitchText = new ViewSwitchText(myResources.getString("HistoryWindow"));
        referenceSwitchText = new ViewSwitchText(myResources.getString("CommandWindow"));
        variableSwitchText = new ViewSwitchText(myResources.getString("VariableWindow"));
        historyWindow = new InformationWindow(historySwitchText, referenceSwitchText, variableSwitchText, historyView);
        setCustomizationPanel();
        historySwitchText.setOnMouseClicked(event -> setHistoryWindow());
        referenceSwitchText.setOnMouseClicked(event -> {
            setCommandsWindow();
        });
        variableSwitchText.setOnMouseClicked(event -> setVariableWindow());
        setFooter();

        inputPanel.getChildren().add(console);
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
        turtleView.setBackground(new Background(new BackgroundFill(backgroundColorSelector.getColorPicker().getValue(), CornerRadii.EMPTY, Insets.EMPTY)));
        //backgroundColorSelector.setButtonColor(backgroundColorSelector.getColorPicker().getValue());
    }
    private void setPenColor() {
        pen.setColor(penColorSelector.getColorPicker().getValue());
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
        penColorSelector.updateLanguage(myResources.getString("ChoosePen"));
        backgroundColorSelector.updateLanguage(myResources.getString("ChooseBackground"));
        turtleButton.setText(myResources.getString("ChooseTurtle"));
    }
    private void setFooter() {
        console.getChildren().add(commandPrompt.getPrompt());
        console.getChildren().add(commandPrompt);
    }
    private void setHistoryWindow() {
        mainFrame.getChildren().remove(mainFrame.getRight());
        historyWindow = new InformationWindow(historySwitchText, referenceSwitchText, variableSwitchText, historyView);
        mainFrame.setRight(historyWindow);
    }
    private void setCommandsWindow() {
        mainFrame.getChildren().remove(mainFrame.getRight());
        referenceWindow = new InformationWindow(historySwitchText, referenceSwitchText, variableSwitchText, referenceView);
        mainFrame.setRight(referenceWindow);
    }
    private void setVariableWindow() {
        mainFrame.getChildren().remove(mainFrame.getRight());
        variableWindow = new InformationWindow(historySwitchText, referenceSwitchText, variableSwitchText, variableView);
        mainFrame.setRight(variableWindow);
    }
    private void setCustomizationPanel() {
        customizationPanel.getChildren().add(languageSelector);
        customizationPanel.getChildren().add(penColorSelector);
        customizationPanel.getChildren().add(backgroundColorSelector);
        //FIXME refactor button
        turtleButton = controlPanel.getTurtleSwitcher();
        customizationPanel.getChildren().add(turtleButton);
        turtleButton.getStyleClass().add("turtleswitch");
        penColorSelector.getColorPicker().setOnAction(event -> setPenColor());
        backgroundColorSelector.getColorPicker().setOnAction(event -> setBackgroundColor(turtleWindow));
        languageSelector.setOnAction(event -> {
            try {
                updateLanguage();
            } catch (IOException e) {
//                    e.printStackTrace();
            }
        });
    }
}




