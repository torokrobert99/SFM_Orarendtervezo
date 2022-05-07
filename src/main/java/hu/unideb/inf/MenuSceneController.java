package hu.unideb.inf;

import hu.unideb.inf.model.Container;
import hu.unideb.inf.model.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuSceneController implements Initializable {
    MainApp m = new MainApp();

    @FXML
    private Label loggedName;

    @FXML
    private Label role;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayName();
    }

    @FXML
    void addSubjectButtonPushed(ActionEvent event) throws IOException {
        m.changeScene("/fxml/FXMLAddSubjectScene.fxml");
    }

    @FXML
    void exitButtonPushed(ActionEvent event) {

    }

    @FXML
    void felvettTargyakButtonPushed(ActionEvent event) {

    }

    @FXML
    void listSubjectButtonPushed(ActionEvent event) {

    }

    @FXML
    void logoutButtonPushed(ActionEvent event) throws IOException {
        m.changeScene("/fxml/FXMLLoginScene.fxml");
    }

    @FXML
    void mentettOrarendekButtonPushed(ActionEvent event){

    }

    @FXML
    void subjectsButtonPushed(ActionEvent event) {

    }

    @FXML
    void targyFelvetelButtonPushed(ActionEvent event) {

    }

    void displayName()
    {
        loggedName.setText(Container.currentActivePerson.getName());
        role.setText(Container.currentActivePerson.getRole().name());
    }


}
