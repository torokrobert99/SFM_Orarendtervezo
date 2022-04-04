package hu.unideb.inf;

import hu.unideb.inf.model.Model;
import hu.unideb.inf.model.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RegisterSceneController {
    private Model model;
    public void setModel(Model model) {this.model = model;}

    @FXML
    private Label errorMessage;

    @FXML
    private TextField passwordAgainInRegister;

    @FXML
    private TextField passwordInRegister;

    @FXML
    private TextField usernameInRegister;

    @FXML
    private RadioButton studentButton;

    @FXML
    private RadioButton teacherButton;


    @FXML
    void cancelButtonPushed(ActionEvent event) throws IOException {
        MainApp m = new MainApp();
        m.changeScene("/fxml/FXMLOrarendScene.fxml");

    }

    @FXML
    void sendingButtonPushed(ActionEvent event) {
        
    }

    void comparePasswords()
    {
        //TODO
    }

    boolean isUsernameTaken()
    {
        //TODO
        return true;
    }
}
