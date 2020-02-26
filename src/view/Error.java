package view;

import javafx.scene.control.Alert;

public class Error {
    private Alert alert;

    public Error(String type){
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Not a valid Command");
        alert.setContentText("Please enter a valid Command. Valid commands can be found in Command List ");
        alert.showAndWait();
    }
}
