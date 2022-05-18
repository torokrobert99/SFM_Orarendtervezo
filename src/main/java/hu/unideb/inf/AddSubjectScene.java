package hu.unideb.inf;

import hu.unideb.inf.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.List;

public class AddSubjectScene {
    MainApp m = new MainApp();
    JpaPersonDAO personDAO = new JpaPersonDAO();
    JpaSubjectDAO subjectDAO = new JpaSubjectDAO();
    JpaSubjectGroupDAO groupDAO = new JpaSubjectGroupDAO();
    Teacher teacher = new Teacher();
    SubjectGroups currentGroup;
    Subject currentSubject;
    @FXML
    private TextField creditValue;

    @FXML
    private Label errorMessage;


    @FXML
    private TextField subjectName;



    @FXML
    void addButtonPushed(ActionEvent event) {
        teacher.setName(Container.currentActivePerson.getName());
        currentSubject = new Subject();
        currentSubject.setSubjectName(subjectName.getText());
        currentSubject.setCredit(Integer.parseInt(creditValue.getText()));
        currentSubject.setTargyfelelos(Container.currentActivePerson.getName());
        subjectDAO.saveSubject(currentSubject);

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

