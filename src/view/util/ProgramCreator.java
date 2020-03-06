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

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


public class ProgramCreator {
    private final int FRAMES_PER_SECOND = 60;
    private final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
    private Scene myScene;
    private Timeline myAnimation;
    private final TurtleWindow turtleWindow = new TurtleWindow();
    private ConsoleModel consoleModel = new ConsoleModel();
    private Controller controller;
    private UserInterface UI;
    private TurtleContainer turtleContainer = new TurtleContainer(turtleWindow);

    public ProgramCreator(Stage stage) throws IllegalAccessException, IOException, InvocationTargetException {
        myAnimation = new Timeline();
        turtleContainer.addTurtle(1);
        turtleContainer.getTurtleModelContainer().makeTurtleActive(1);
        controller = new Controller(turtleWindow, consoleModel,turtleContainer );
        UI = new UserInterface(stage, "English", turtleWindow, controller, turtleContainer);
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
