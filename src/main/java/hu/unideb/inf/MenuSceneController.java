package hu.unideb.inf;

import hu.unideb.inf.model.Container;
import hu.unideb.inf.model.Person;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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

    @FXML
    private Button exitButton;

    @FXML
    private Button strudentTargyFelvetel;

    @FXML
    private Button studentFelvettTargyak;

    @FXML
    private Button studentMentettOrarendek;

    @FXML
    private Button teacherCsoportHozzadas;

    @FXML
    private Button teacherTargyHozzaadas;

    @FXML
    private Button teacherTargyakLista;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayName();
        if(Container.currentActivePerson.getRole().name().equals("TEACHER"))
        {
            studentMentettOrarendek.setDisable(true);
            strudentTargyFelvetel.setDisable(true);
            studentFelvettTargyak.setDisable(true);
        }
        else
        {
            teacherCsoportHozzadas.setDisable(true);
            teacherTargyakLista.setDisable(true);
            teacherTargyHozzaadas.setDisable(true);
        }
    }

    //TEACHER METÓDUSOK
    @FXML
    void addSubjectButtonPushed(ActionEvent event) throws IOException {
        m.changeScene("/fxml/FXMLAddSubjectScene.fxml");
    }

    @FXML
    void listOfSubjectsButtonPushed(ActionEvent event) throws IOException {
        m.changeScene("/fxml/FXMLSubjectListScene.fxml");

    }

    @FXML
    void addGroupToSubjectButtonPushed(ActionEvent event) throws IOException {
        m.changeScene("/fxml/FXMLAddGroupScene.fxml");
    }
    //--------------------------------------------------------------------------------------------

    //STUDENT METÓDUSOK

    @FXML
    void targyFelvetelButtonPushed(ActionEvent event) throws IOException {
        m.changeScene("/fxml/FXMLTargyfelvetelScene.fxml");
    }

    @FXML
    void felvettTargyakButtonPushed(ActionEvent event) {

    }

    @FXML
    void mentettOrarendekButtonPushed(ActionEvent event) {

    }

    //------------------------------------------------------------------------------------------

    @FXML
    void exitButtonPushed(ActionEvent event) {
        exitButton.setOnAction(actionEvent -> Platform.exit());
    }

    @FXML
    void logoutButtonPushed(ActionEvent event) throws IOException {
        m.changeScene("/fxml/FXMLLoginScene.fxml");
    }


    void displayName() {
        loggedName.setText(Container.currentActivePerson.getName());
        role.setText(Container.currentActivePerson.getRole().name());
    }


}
