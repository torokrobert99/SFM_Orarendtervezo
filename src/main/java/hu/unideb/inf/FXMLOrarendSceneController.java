package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class FXMLOrarendSceneController {

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    void handledLoginButtonPushed(ActionEvent event) {
        System.out.println(passwordField.getText());
        /* adok pár sor kommentet a teszt kedvéért */
        /* így ni nagyon szép lesz*/

    }

    @FXML
    void handledRegisterButtonPushed(ActionEvent event) {

    }

}
