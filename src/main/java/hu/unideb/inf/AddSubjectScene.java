package hu.unideb.inf;

import hu.unideb.inf.model.Container;
import hu.unideb.inf.model.JpaSubjectDAO;
import hu.unideb.inf.model.Person;
import hu.unideb.inf.model.Subject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddSubjectScene {
    MainApp m = new MainApp();
    JpaSubjectDAO subjectDAO = new JpaSubjectDAO();
    @FXML
    private TextField creditValue;

    @FXML
    private Label errorMessage;

    @FXML
    private TextField subjectName;

    @FXML
    void addButtonPushed(ActionEvent event) {
        Subject currentSubject = new Subject();
        currentSubject.setSubjectName(subjectName.getText());
        currentSubject.setCredit(Integer.parseInt(creditValue.getText()));
        currentSubject.setTeacherId(Container.currentActivePerson.getName());
    }

    @FXML
    void cancelButtonPushed(ActionEvent event) throws IOException {
        m.changeScene("/fxml/FXMLMenuScene.fxml");
    }
    boolean isCreditValueValid()
    {
        return Integer.parseInt(creditValue.getText()) >= 3 && Integer.parseInt(creditValue.getText()) <= 6;
    }

}

