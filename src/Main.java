import controller.Controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import model.ConsoleModel;
import model.MethodModel;
import model.TurtleContainer;
import model.TurtleModel;
import view.layout.TurtleWindow;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import view.layout.UserInterface;
import view.util.ProgramCreator;

/**
 * Feel free to completely change this code or delete it entirely. 
 */
public class Main extends Application {
    /**
     * Start of the program.
     */
    ProgramCreator initialProgram;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IllegalAccessException, IOException, InvocationTargetException {
        initialProgram = new ProgramCreator(primaryStage);
    }
}
