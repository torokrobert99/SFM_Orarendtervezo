package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class FXMLOrarendSceneController
{

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    private Button registerButton;

    @FXML
    void handledLoginButtonPushed(ActionEvent event)
    {
        System.out.println("Hello world");

    }

    @FXML
    void handledRegisterButtonPushed(ActionEvent event) throws IOException
    {
       MainApp m = new MainApp();
       m.changeScene("/fxml/FXMLRegisterScene.fxml");

    }

    boolean checkCredentials()
    {
        //TODO
        return true;
    }

}
