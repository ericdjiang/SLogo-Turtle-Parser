package View;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
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

    private String myLanguage;
    private ResourceBundle myResources;

    private HBox hb = new HBox();
    private HBox hb2 = new HBox();
    private VBox historyViewWindow = new VBox();
    private VBox vb3 = new VBox();
    private VBox vb4 = new VBox();
    private VBox vb = new VBox();
    private VBox content2 = new VBox();
    private VBox content3 = new VBox();

    private BorderPane bp = new BorderPane();
    private BorderPane bp2 = new BorderPane();

    private ColorPicker colorPicker = new ColorPicker();
    private ViewSwitchText historySwitchText;
    private ViewSwitchText referenceSwitchText;
    private ViewSwitchText variableSwitchText;

    private boolean flipped;
    private TurtleView turtleWindow;
    private Parser parser;
    private CommandReferenceView referenceView;
    private CommandHistoryView historyView;
    private VariableView variableView;
    private Console commandPrompt;
    private LanguageSelector languageSelector;
    private ControlPanel controlPanel;



    /**
     * create a UI object that houses all animation function and simulation loading functionality
     * @param stage
     * @param language
     */
    public UserInterface(Stage stage, String language, TurtleView turtleView) throws IOException, InvocationTargetException, IllegalAccessException {
        this.myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
        this.myLanguage = language;
        this.turtleWindow = turtleView;
        this.referenceView = new CommandReferenceView(language);
        this.commandPrompt = new Console(myResources);
        this.historyView = new CommandHistoryView(myResources);
        this.variableView = new VariableView(myResources);
        this.languageSelector = new LanguageSelector(myResources);
        this.controlPanel = new ControlPanel(myResources, historyView, commandPrompt);
        stage.setTitle(myResources.getString("Title"));
        //this.parser = new Parser();

    }

    /**
     * initialize main visuals of UI including hbox and vbox housing buttons, sliders,
     * and a spot for sim specific ui
     * @return
     */
    public Scene setupUI() throws IOException {
        historySwitchText = new ViewSwitchText(myResources.getString("HistoryWindow"));
        referenceSwitchText = new ViewSwitchText(myResources.getString("CommandWindow"));
        variableSwitchText = new ViewSwitchText(myResources.getString("VariableWindow"));
        hb.getChildren().add(languageSelector);
        hb.getChildren().add(colorPicker);
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
            try {
                setCommandsWindow();
            } catch (IOException e) {
//                    e.printStackTrace();
            }
        });
        variableSwitchText.setOnMouseClicked(event -> setVariableWindow());
        vb.getChildren().add(controlPanel.getRunButton());
        vb.getChildren().add(controlPanel.getClearButton());
        hb2.getChildren().add(commandPrompt);
        hb2.getChildren().add(vb);
        historyViewWindow.getChildren().add(historySwitchText);
        historyViewWindow.getChildren().add(referenceSwitchText);
        historyViewWindow.getChildren().add(variableSwitchText);
        historyViewWindow.getChildren().add(historyView);
        colorPicker.setPromptText("Set Background Color");
        bp.setBottom(hb2);
        bp.setTop(hb);
        //bp.setRight(sp);
        bp.setCenter(turtleWindow);
        bp2.setCenter(bp);
        bp2.setRight(historyViewWindow);
        content2.getChildren().addAll(new Text("fd = forward"), new Text("bk = backward"));
        content3.getChildren().addAll(new Text("x = 42"));

        Scene myScene = new Scene(bp2, WIDTH, HEIGHT);
        myScene.getStylesheets().add(STYLESHEET);

        return myScene;
    }
    private void setBackgroundColor(Pane tv) {
        tv.setBackground(new Background(new BackgroundFill(colorPicker.getValue(), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    private void updateLanguage() throws IOException {
        ResourceBundle r = ResourceBundle.getBundle("resources/parsing.Unicode");
        String l = r.getString(languageSelector.getValue());
        myLanguage = l;
        //parser.addPatterns(l);
        System.out.println(l);
//            if (l.equals("Urdu")) {
//                flipped = true;
//            }
//            else {
//                flipped = false;
//            }
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + l);
        commandPrompt.updateLanguage(myResources);
        referenceView.initializeReferences(myLanguage);
        setCommandsWindow();
        controlPanel.updateLanguage(myResources);
        historySwitchText.updateLanguage(myResources.getString("HistoryWindow"));
        referenceSwitchText.updateLanguage(myResources.getString("CommandWindow"));
        variableSwitchText.updateLanguage(myResources.getString("VariableWindow"));
    }
    //probably refactor windows into another class and call a contructor to set right
    private void setHistoryWindow() {
        bp2.getChildren().remove(bp2.getRight());
        historyViewWindow.getChildren().removeAll(historySwitchText, referenceSwitchText, variableSwitchText, historyView);
        historyViewWindow.getChildren().add(historySwitchText);
        historyViewWindow.getChildren().add(referenceSwitchText);
        historyViewWindow.getChildren().add(variableSwitchText);
        historyViewWindow.getChildren().add(historyView);
        if (! flipped) {
            bp2.setRight(historyViewWindow);
        }
        else {
            bp2.setLeft(historyViewWindow);
        }
    }
    private void setCommandsWindow() throws IOException {
        bp2.getChildren().remove(bp2.getRight());
        vb3.getChildren().removeAll(historySwitchText, referenceSwitchText, variableSwitchText, referenceView);
        vb3.getChildren().add(historySwitchText);
        vb3.getChildren().add(referenceSwitchText);
        vb3.getChildren().add(variableSwitchText);
        vb3.getChildren().add(referenceView);
        if (! flipped) {
            bp2.setRight(vb3);
        }
        else {
            bp2.setLeft(vb3);
        }
    }
    private void setVariableWindow() {
        bp2.getChildren().remove(bp2.getRight());
        vb4.getChildren().removeAll(historySwitchText, referenceSwitchText, variableSwitchText, variableView);
        vb4.getChildren().add(historySwitchText);
        vb4.getChildren().add(referenceSwitchText);
        vb4.getChildren().add(variableSwitchText);
        vb4.getChildren().add(variableView);
        if (! flipped) {
            bp2.setRight(vb4);
        }
        else {
            bp2.setLeft(vb4);
        }
    }


}




