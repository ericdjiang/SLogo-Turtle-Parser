package view.views;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.VariableModel;

public class VariableText extends Text{
    private int myIndex;

    public VariableText(String name, int index){
        myIndex= index;
        setText(name);

    }

    public int getIndex(){
        return myIndex;
    }
}
