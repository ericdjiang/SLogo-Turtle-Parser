package view;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ViewSwitchText extends Text {
    public ViewSwitchText(String s) {
        setText(s);
        setFont(Font.font(9.5));
        setFill(Color.BLUE);
        setOnMouseEntered(event -> animateLink());
        setOnMouseExited(event -> removeUnderline());
    }
    private void animateLink() {
        this.setUnderline(true);
    }
    private void removeUnderline() {
        this.setUnderline(false);
    }
    public void updateLanguage(String s) {
        setText(s);
    }
}
