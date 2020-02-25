package View;

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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import parsing.Parser;

import javax.imageio.ImageIO;
import java.io.File;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UserInterface {
    private static final int HEIGHT = 600;
    private static final int WIDTH = 850;

    private static final String RESOURCES = "resources/languages";
    private static final String DEFAULT_RESOURCE_PACKAGE = RESOURCES + ".";
    private static final String DEFAULT_RESOURCE_FOLDER = "/" + RESOURCES + "/";
    private static final String STYLESHEET = "resources/stylesheets/default.css";
    private static final String EXTENSION = ".properties";
    private String myLanguage;
    private ResourceBundle myResources;

    private HBox hb = new HBox();
    private HBox hb2 = new HBox();
    private VBox vb2 = new VBox();
    private VBox vb3 = new VBox();
    private VBox vb4 = new VBox();
    private VBox vb = new VBox();
    private VBox content = new VBox();
    private VBox content2 = new VBox();
    private VBox content3 = new VBox();
    private Button b = new Button("Run");
    private Button b2 = new Button("Clear");
    private ScrollPane sp = new ScrollPane();
    private ScrollPane sp2 = new ScrollPane();
    private ScrollPane sp3 = new ScrollPane();
    private BorderPane bp = new BorderPane();
    private BorderPane bp2 = new BorderPane();
    //private StackPane st = new StackPane();
    private ComboBox<String> cb = new ComboBox<>();
    private ColorPicker cp = new ColorPicker();
    private TextArea ta = new TextArea();
    private Text t = new Text();
    private Text t2 = new Text();
    private Text t3 = new Text();


    private boolean flipped;
    private TurtleView turtleWindow;
    private Parser parser;
    private CommandReferenceView referenceWindow;



    /**
     * create a UI object that houses all animation function and simulation loading functionality
     * @param stage
     * @param language
     */
    public UserInterface(Stage stage, String language, TurtleView turtleView) throws IOException, InvocationTargetException, IllegalAccessException {
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
        myLanguage = language;
        stage.setTitle(myResources.getString("Title"));
        this.turtleWindow = turtleView;
        getFileNames();
        this.referenceWindow = new CommandReferenceView(language);
        //this.parser = new Parser();


    }

    /**
     * initialize main visuals of UI including hbox and vbox housing buttons, sliders,
     * and a spot for sim specific ui
     * @return
     */
    public Scene setupUI() throws IOException {
        t.setText(myResources.getString("HistoryWindow"));
        t2.setText(myResources.getString("CommandWindow"));
        t3.setText(myResources.getString("VariableWindow"));
        t.setFont(Font.font(9.5));
        t2.setFont(Font.font(9.5));
        t3.setFont(Font.font(9.5));
        t.setFill(Color.BLUE);
        t2.setFill(Color.BLUE);
        t3.setFill(Color.BLUE);
        t.setOnMouseEntered(event -> animateLink(t));
        t2.setOnMouseEntered(event -> animateLink(t2));
        t3.setOnMouseEntered(event -> animateLink(t3));
        t.setOnMouseExited(event -> removeUnderline(t));
        t2.setOnMouseExited(event -> removeUnderline(t2));
        t3.setOnMouseExited(event -> removeUnderline(t3));
        turtleWindow.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        hb.getChildren().add(cb);
        hb.getChildren().add(cp);
        cp.setOnAction(event -> setBackgroundColor(turtleWindow));
        b.setOnAction(event -> {
            try {
                executeRun();
            } catch (InvocationTargetException e) {
               e.printStackTrace();
            } catch (IllegalAccessException | NoSuchMethodException | InstantiationException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        cb.setOnAction(event -> {
            try {
                updateLanguage();
            } catch (IOException e) {
//                    e.printStackTrace();
            }
        });
        b2.setOnAction(event -> clearConsole());
        t.setOnMouseClicked(event -> setHistoryWindow());
        t2.setOnMouseClicked(event -> {
            try {
                setCommandsWindow(myLanguage);
            } catch (IOException e) {
//                    e.printStackTrace();
            }
        });
        t3.setOnMouseClicked(event -> setVariableWindow());
        ta.setPromptText(myResources.getString("EnterText"));
        cb.setPromptText(myResources.getString("LanguageSelect"));
        vb.getChildren().add(b);
        vb.getChildren().add(b2);
        hb2.getChildren().add(ta);
        hb2.getChildren().add(vb);
        vb2.getChildren().add(t);
        vb2.getChildren().add(t2);
        vb2.getChildren().add(t3);
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
        bp.setCenter(turtleWindow);
        sp.setContent(content);
        //st.getChildren().add(bp);
        //st.setMargin(sp, new Insets(0, 0, 0, 650));
        //st.getChildren().add(sp);
        bp2.setCenter(bp);
        bp2.setRight(vb2);
        content2.getChildren().addAll(new Text("fd = forward"), new Text("bk = backward"));
        content3.getChildren().addAll(new Text("x = 42"));
        sp2.setContent(content2);
        sp3.setContent(content3);
        Scene myScene = new Scene(bp2, WIDTH, HEIGHT);
        myScene.getStylesheets().add(STYLESHEET);

        return myScene;
    }
    private void setBackgroundColor(Pane tv) {
        tv.setBackground(new Background(new BackgroundFill(cp.getValue(), CornerRadii.EMPTY, Insets.EMPTY)));
    }
    private void executeRun() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException {
        String commands = ta.getText();
        parser = new Parser(commands,myLanguage);
        turtleWindow.setTurtleXPos(turtleWindow.getTurtleXPos() + 50);
        turtleWindow.setTurtleRotation(turtleWindow.getTurtleRotation()+15);
        updateInputHistory(commands);
    }
    private void updateInputHistory(String commands){
        Text l = new Text(commands);
        l.setWrappingWidth(200);
        content.getChildren().add(l);
    }
    private void animateLink(Text text) {
        text.setUnderline(true);
    }
    private void removeUnderline(Text text) {
        text.setUnderline(false);
    }

    private void clearConsole() {
        ta.clear();
    }
    private void updateLanguage() throws IOException {
        ResourceBundle r = ResourceBundle.getBundle("resources/parsing.Unicode");
        String l = r.getString(cb.getValue());
        myLanguage = l;
        //parser.addPatterns(l);
        System.out.println(l);
//            if (l.equals("Urdu")) {
//                flipped = true;
//            }
//            else {
//                flipped = false;
//            }
        //setCommandsWindow(myLanguage);
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + l);
        ta.setPromptText(myResources.getString("EnterText"));
        b.setText(myResources.getString("Run"));
        b2.setText(myResources.getString("Clear"));
        t.setText(myResources.getString("HistoryWindow"));
        t2.setText(myResources.getString("CommandWindow"));
        t3.setText(myResources.getString("VariableWindow"));
    }
    //probably refactor windows into another class and call a contructor to set right
    private void setHistoryWindow() {
        bp2.getChildren().remove(bp2.getRight());
        vb2.getChildren().removeAll(t, t2, t3, sp);
        vb2.getChildren().add(t);
        vb2.getChildren().add(t2);
        vb2.getChildren().add(t3);
        vb2.getChildren().add(sp);
        if (! flipped) {
            bp2.setRight(vb2);
        }
        else {
            bp2.setLeft(vb2);
        }
    }
    private void setCommandsWindow(String language) throws IOException {
        bp2.getChildren().remove(bp2.getRight());
        vb3.getChildren().removeAll(t, t2, t3, referenceWindow);
        vb3.getChildren().add(t);
        vb3.getChildren().add(t2);
        vb3.getChildren().add(t3);
        referenceWindow = new CommandReferenceView(language);
        vb3.getChildren().add(referenceWindow);
        if (! flipped) {
            bp2.setRight(vb3);
        }
        else {
            bp2.setLeft(vb3);
        }
    }
    private void setVariableWindow() {
        bp2.getChildren().remove(bp2.getRight());
        vb4.getChildren().removeAll(t, t2, t3, sp3);
        vb4.getChildren().add(t);
        vb4.getChildren().add(t2);
        vb4.getChildren().add(t3);
        vb4.getChildren().add(sp3);
        if (! flipped) {
            bp2.setRight(vb4);
        }
        else {
            bp2.setLeft(vb4);
        }
    }
    private void getFileNames() {
        File folder = new File("src/resources/languages");
        ResourceBundle r = ResourceBundle.getBundle("resources/parsing.Unicode");
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




