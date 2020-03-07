package view.views;

import javafx.scene.layout.HBox;

public class Library extends HBox {
    private String myText;

    public Library(String text){
        myText = text;
    }
    public String getText(){
        return myText;
    }
    public void setText(String text){
        myText = text;
    }
}
