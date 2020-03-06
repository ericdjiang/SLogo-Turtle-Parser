package view.layout;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.TurtleContainer;
import view.util.ColorSelector;
import view.views.*;
import view.util.ControlPanel;
import view.util.LanguageSelector;
import view.util.Pen;

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
    private ViewSwitchText tabs;
    private TurtleWindow turtleWindow;
    private CommandReferenceView referenceView;
    private CommandHistoryView historyView;
    private VariableView variableView;
    private LibraryView libraryView;
    private ConsoleView commandPrompt;
    private LanguageSelector languageSelector;
    private ControlPanel controlPanel;
    public InformationWindow historyWindow;
    private InformationWindow referenceWindow;
    private InformationWindow variableWindow;
    private InformationWindow libraryWindow;
    private CustomizationView customizationView;
    private InformationWindow customizationWindow;
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
        this.libraryView = new LibraryView(myResources);
        this.languageSelector = new LanguageSelector(myResources);
        this.controlPanel = new ControlPanel(myResources, historyView, commandPrompt, myLanguage, c, c.getConsoleModel(), variableView,turtleContainer );
        this.controller = c;
        this.customizationView = c.getStats();
        this.pen = c.getPen();
        this.backgroundColorSelector = new ColorSelector(myResources.getString("ChooseBackground"));
        this.penColorSelector = new ColorSelector(myResources.getString("ChoosePen"));
        this.tabs = new ViewSwitchText(myResources);
        stage.setTitle(myResources.getString("Title"));
    }
    public Scene setupUI() {
        historyWindow = new InformationWindow(tabs, historyView);
        setCustomizationPanel();
        tabs.getHistoryTab().setOnMouseClicked(event -> setHistoryWindow());
        tabs.getReferenceTab().setOnMouseClicked(event -> {
            setCommandsWindow();
        });
        tabs.getVariableTab().setOnMouseClicked(event -> setVariableWindow());
        tabs.getLibraryTab().setOnMouseClicked(event -> setLibraryWindow());
        tabs.getCustomizationTab().setOnMouseClicked(event -> setCustomizationWindow());
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
    private void setBackgroundColor(TurtleWindow turtleWindow) {
        turtleWindow.setBackground(new Background(new BackgroundFill(backgroundColorSelector.getColorPicker().getValue(), CornerRadii.EMPTY, Insets.EMPTY)));
        turtleWindow.setColor(backgroundColorSelector.getColorPicker().getValue());
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
        tabs.updateLanguage(myResources);
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
        historyWindow = new InformationWindow(tabs, historyView);
        mainFrame.setRight(historyWindow);
    }
    private void setCommandsWindow() {
        mainFrame.getChildren().remove(mainFrame.getRight());
        referenceWindow = new InformationWindow(tabs, referenceView);
        mainFrame.setRight(referenceWindow);
    }
    private void setVariableWindow() {
        mainFrame.getChildren().remove(mainFrame.getRight());
        variableWindow = new InformationWindow(tabs, variableView);
        mainFrame.setRight(variableWindow);
    }
    private void setLibraryWindow() {
        mainFrame.getChildren().remove(mainFrame.getRight());
        libraryWindow = new InformationWindow(tabs, libraryView);
        mainFrame.setRight(libraryWindow);
    }
    private void setCustomizationWindow() {
        mainFrame.getChildren().remove(mainFrame.getRight());
        customizationWindow = new InformationWindow(tabs, customizationView);
        customizationView.setOnMouseExited(event -> {
            pen.setDashOffset(customizationView.getDashWidth());
            pen.setStrokeWidth(customizationView.getThickness());
        });
        mainFrame.setRight(customizationWindow);
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





