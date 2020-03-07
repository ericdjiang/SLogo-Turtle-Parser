package view.util;

import controller.Controller;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.ConsoleModel;

import model.TurtleContainer;

import view.layout.TurtleWindow;
import view.layout.UserInterface;
import view.views.ConsoleView;

import java.io.Console;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ResourceBundle;


public class ProgramCreator {
    private final int FRAMES_PER_SECOND = 60;
    private final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
    private static final String RESOURCES = "resources/languages";
    private static final String DEFAULT_RESOURCE_FOLDER = "/" + RESOURCES + "/";
    private static final String DEFAULT_RESOURCE_PACKAGE = RESOURCES + ".";
    private Scene myScene;
    private Timeline myAnimation;
    private ResourceBundle myResources;
    private final TurtleWindow turtleWindow = new TurtleWindow();
    private Controller controller;
    private ControlPanel controlPanel;
    private UserInterface UI;
    private ConsoleView console;
    private TurtleContainer turtleContainer = new TurtleContainer(turtleWindow);

    public ProgramCreator(Stage stage) throws IllegalAccessException, IOException, InvocationTargetException {
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "English");
        this.console = new ConsoleView(myResources);
        UI = new UserInterface(stage, myResources, turtleWindow, console);
        myAnimation = new Timeline();
        controller = new Controller(turtleWindow, UI.getCustomizationView(), UI.getHistoryView(), UI.getVariableView());
        controlPanel = new ControlPanel(myResources, console, turtleContainer, controller);
        UI.addControlPanel(controlPanel);
        myScene = UI.setupUI();
        stage.setScene(myScene);
        stage.show();
        stage.setResizable(false);

        KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> {
            step();
        });
        myAnimation.setCycleCount(Timeline.INDEFINITE);
        myAnimation.getKeyFrames().add(frame);
        myAnimation.play();
    }

    private void step() {
        controller.update();
    }
}
