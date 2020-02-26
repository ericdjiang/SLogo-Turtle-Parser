import view.TurtleView;
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
    private final int FRAMES_PER_SECOND = 1;
    private final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
    private Scene myScene;
    private Timeline myAnimation;
    private final TurtleView turtleView = new TurtleView();
    private UserInterface UI;


    public static void main (String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        myAnimation = new Timeline();
        UI = new UserInterface(primaryStage, "English", turtleView);
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
    }

}
