package view.layout;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.TurtleContainer;
import view.views.VariableView;
import view.util.ControlPanel;
import view.util.LanguageSelector;
import view.util.Pen;
import view.views.CommandHistoryView;
import view.views.CommandReferenceView;
import view.views.ConsoleView;

import javax.imageio.ImageIO;
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
    private Button backgroundButton;
    private Button penButton;
    private Button turtleButton;

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
        this.backgroundButton = makeButton("ChooseBackGround", e-> colorPicker.show());
        this.penButton = makeButton("ChoosePen", e-> penColorPicker.show());
        stage.setTitle(myResources.getString("Title"));
    }
    public Scene setupUI() {
        historySwitchText = new ViewSwitchText(myResources.getString("HistoryWindow"));
        referenceSwitchText = new ViewSwitchText(myResources.getString("CommandWindow"));
        variableSwitchText = new ViewSwitchText(myResources.getString("VariableWindow"));
        historyWindow = new CommandHistoryWindow(historySwitchText, referenceSwitchText, variableSwitchText, historyView);
        customizationPanel.getChildren().add(languageSelector);

        StackPane backGroundColorBox = new StackPane();
        backgroundButton.getStyleClass().add("colorbutton");
        penButton.getStyleClass().add("colorbutton");
        backGroundColorBox.getChildren().add(colorPicker);
        colorPicker.setOnMouseClicked(e-> colorPicker.hide());
        backGroundColorBox.getChildren().add(backgroundButton);
        backGroundColorBox.getStyleClass().add("colorbox");
        StackPane penColorBox = new StackPane();
        penColorBox.getChildren().add(penColorPicker);
        penColorBox.getChildren().add(penButton);
        customizationPanel.getChildren().add(penColorBox);
        customizationPanel.getChildren().add(backGroundColorBox);

        penColorPicker.setValue(Color.BLACK);
        penColorPicker.getStyleClass().add("colorpicker");
        colorPicker.getStyleClass().add("colorpicker");
        //FIXME refactor button
        turtleButton = controlPanel.getTurtleSwitcher();
        customizationPanel.getChildren().add(turtleButton);
        turtleButton.getStyleClass().add("turtleswitch");
        penColorPicker.setOnAction(event -> setPenColor());
        colorPicker.setOnAction(event -> setBackgroundColor(turtleWindow));
        penColorPicker.hide();
        colorPicker.hide();
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
        penButton.setText(myResources.getString("ChoosePen"));
        backgroundButton.setText(myResources.getString("ChooseBackGround"));
        turtleButton.setText(myResources.getString("ChooseTurtle"));
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

    private Button makeButton(String property, EventHandler<ActionEvent> handler) {
        // represent all supported image suffixes
        ResourceBundle resources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + myLanguage);
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

}




