package userInterface;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

import java.util.ResourceBundle;

public class UIMain {
        private static final int HEIGHT = 600;
        private static final int WIDTH = 850;

        private static final String RESOURCES = "resources/languages";
        private static final String DEFAULT_RESOURCE_PACKAGE = RESOURCES + ".";
        private static final String DEFAULT_RESOURCE_FOLDER = "/" + RESOURCES + "/";
        private static final String STYLESHEET = "resources/stylesheets/default.css";
        private static final String EXTENSION = ".properties";

        private  ResourceBundle myResources;

        private HBox hb = new HBox();
        private HBox hb2 = new HBox();
        private VBox vb2 = new VBox();
        private VBox vb3 = new VBox();
        private VBox vb = new VBox();
        private VBox content = new VBox();
        private VBox content2 = new VBox();
        private Button b = new Button("Clear");
        private Button b2 = new Button("Run");
        private ScrollPane sp = new ScrollPane();
        private ScrollPane sp2 = new ScrollPane();
        private BorderPane bp = new BorderPane();
        private BorderPane bp2 = new BorderPane();
        //private StackPane st = new StackPane();
        private ComboBox<String> cb = new ComboBox<>();
        private ColorPicker cp = new ColorPicker();
        private TextArea ta = new TextArea();
        private Text t = new Text("History");
        private Text t2 = new Text("Commands");
        private Rectangle r = new Rectangle(50, 50);

        private boolean flipped;


        /**
         * create a UI object that houses all animation function and simulation loading functionality
         * @param stage
         * @param language
         */
        public UIMain(Stage stage, String language) {
            myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
            stage.setTitle("Parser_Team08");
            getFileNames();

        }

    /**
         * initialize main visuals of UI including hbox and vbox housing buttons, sliders,
         * and a spot for sim specific ui
         * @param turtleView
         * @return
         */
        public Scene setupUI(Pane turtleView) {
            t.setFill(Color.BLUE);
            t2.setFill(Color.BLUE);
            t.setOnMouseEntered(event -> animateLink1());
            t2.setOnMouseEntered(event -> animateLink2());
            t.setOnMouseExited(event -> removeUnderline1());
            t2.setOnMouseExited(event -> removeUnderline2());
            turtleView.setBorder(new Border(new BorderStroke(Color.BLACK,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            hb.getChildren().add(cb);
            hb.getChildren().add(cp);
            cp.setOnAction(event -> setBackgroundColor(turtleView));
            b2.setOnAction(event -> updateInputHistory());
            cb.setOnAction(event -> updateLanguage());
            b.setOnAction(event -> clearConsole());
            t.setOnMouseClicked(event -> setHistoryWindow());
            t2.setOnMouseClicked(event -> setCommandsWindow());
            ta.setPromptText(myResources.getString("EnterText"));
            cb.setPromptText("Select Language");
            vb.getChildren().add(b);
            vb.getChildren().add(b2);
            hb2.getChildren().add(ta);
            hb2.getChildren().add(vb);
            vb2.getChildren().add(t);
            vb2.getChildren().add(t2);
            vb2.getChildren().add(sp);
            cp.setPromptText("Set Background Color");
            //hb.setSpacing(450);
            //AnchorPane.setLeftAnchor(turtleView, 0.0);
            //AnchorPane.setTopAnchor(hb,0.0);
            //AnchorPane.setRightAnchor(sp, 0.0);
            //AnchorPane.setBottomAnchor(hb2, 0.0);
            //bp.getChildren().add(hb);
            //bp.getChildren().add(sp);
            //bp.getChildren().add(hb2);
            //bp.getChildren().add(turtleView);
            bp.setBottom(hb2);
            bp.setTop(hb);
            //bp.setRight(sp);
            bp.setCenter(turtleView);
            sp.setContent(content);
            //st.getChildren().add(bp);
            //st.setMargin(sp, new Insets(0, 0, 0, 650));
            //st.getChildren().add(sp);
            bp2.setCenter(bp);
            bp2.setRight(vb2);
            content2.getChildren().addAll(new Text("fd = forward"), new Text("bk = backward"));
            sp2.setContent(content2);
            r.setX(100);
            r.setY(100);
            turtleView.getChildren().add(r);
            Scene myScene = new Scene(bp2, WIDTH, HEIGHT);
            myScene.getStylesheets().add(STYLESHEET);
            return myScene;
        }
        private void setBackgroundColor(Pane tv) {
            tv.setBackground(new Background(new BackgroundFill(cp.getValue(), CornerRadii.EMPTY, Insets.EMPTY)));
        }
        private void updateInputHistory() {
            Text l = new Text(ta.getText());
            l.setWrappingWidth(200);
            content.getChildren().add(l);
            r.setX(r.getX()+50);
        }
        private void animateLink1() {
            t.setUnderline(true);
        }
        private void animateLink2() {
            t2.setUnderline(true);
        }
        private void removeUnderline1() {
            t.setUnderline(false);
        }
        private void removeUnderline2() {
            t2.setUnderline(false);
    }
        private void clearConsole() {
            ta.clear();
        }
        private void updateLanguage() {
            ResourceBundle r = ResourceBundle.getBundle("resources/languages.Unicode");
            String l = r.getString(cb.getValue());
            System.out.println(l);
            if (l.equals("Urdu")) {
                flipped = true;
            }
            else {
                flipped = false;
            }
            myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + l);
            ta.setPromptText(myResources.getString("EnterText"));
            b.setText(myResources.getString("Run"));
            b2.setText(myResources.getString("Clear"));
        }
        //probably refactor windows into another class and call a contructor to set right
        private void setHistoryWindow() {
            bp2.getChildren().remove(bp2.getRight());
            vb2.getChildren().removeAll(t, t2, sp);
            vb2.getChildren().add(t);
            vb2.getChildren().add(t2);
            vb2.getChildren().add(sp);
            if (! flipped) {
                bp2.setRight(vb2);
            }
            else {
                bp2.setLeft(vb2);
            }
        }
        private void setCommandsWindow() {
            bp2.getChildren().remove(bp2.getRight());
            vb3.getChildren().removeAll(t, t2, sp2);
            vb3.getChildren().add(t);
            vb3.getChildren().add(t2);
            vb3.getChildren().add(sp2);
            if (! flipped) {
                bp2.setRight(vb3);
            }
            else {
                bp2.setLeft(vb3);
            }
        }
        private void getFileNames() {
            File folder = new File("src/resources/languages");
            ResourceBundle r = ResourceBundle.getBundle("resources/languages.Unicode");
            File[] listOfFiles = folder.listFiles();
            assert listOfFiles != null;
            for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile() && listOfFile.getName().contains(EXTENSION)) {
                cb.getItems().add(r.getString(listOfFile.getName().split(EXTENSION)[0]));
            }
            }
        }
    public Button makeButton(String property, EventHandler<ActionEvent> handler) {
        // represent all supported image suffixes
        final String IMAGEFILE_SUFFIXES = String
                .format(".*\\.(%s)", String.join("|", ImageIO.getReaderFileSuffixes()));
        Button result = new Button();
        String label = myResources.getString(property);
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




