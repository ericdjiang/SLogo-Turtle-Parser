import controller.Controller;
import model.ConsoleModel;
import model.TurtleModel;
import view.TurtleWindow;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import view.UserInterface;

/**
 * Feel free to completely change this code or delete it entirely. 
 */
public class Main extends Application {
    /**
     * Start of the program.
     */
    private final int FRAMES_PER_SECOND = 60;
    private final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
    private Scene myScene;
    private Timeline myAnimation;
    private final TurtleWindow turtleWindow = new TurtleWindow();
    private ConsoleModel consoleModel = new ConsoleModel();
    private Controller controller;
    private UserInterface UI;
    private TurtleModel turtleModel;


    public static void main (String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        myAnimation = new Timeline();
        turtleModel = new TurtleModel(0, 0, 0);
        controller = new Controller(turtleModel, turtleWindow, consoleModel);
        UI = new UserInterface(primaryStage, "English", turtleWindow, controller);
        myScene = UI.setupUI();
        primaryStage.setScene(myScene);
        primaryStage.show();
        primaryStage.setResizable(false);

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
