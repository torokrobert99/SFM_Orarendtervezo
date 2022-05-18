package hu.unideb.inf;

import hu.unideb.inf.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class AddSubjectController implements Initializable {
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
    private ChoiceBox<Integer> creditsMenu;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Integer> creditValues = new ArrayList<>(Arrays.asList(2,3,4,5,6));
        creditsMenu.getItems().addAll(creditValues);

    }
    @FXML
    void addButtonPushed(ActionEvent event) throws IOException {
        boolean subjectAlreadyExist = checkSubjectAlreadyExist();
        if(!subjectAlreadyExist && !subjectName.getText().equals("")) {
            teacher.setName(Container.currentActivePerson.getName());
            currentSubject = new Subject();
            currentSubject.setSubjectName(subjectName.getText());
            currentSubject.setCredit(creditsMenu.getValue());
            currentSubject.setTargyfelelos(Container.currentActivePerson.getName());
            subjectDAO.saveSubject(currentSubject);
            m.changeScene("/fxml/FXMLMenuScene.fxml");
        }
        else
        {
            errorMessage.setText("Hiba! A tárgy már létezik vagy üresen hagyott mező!");
        }
    }

    @FXML
    void cancelButtonPushed(ActionEvent event) throws IOException {
        m.changeScene("/fxml/FXMLMenuScene.fxml");
    }
    public boolean checkSubjectAlreadyExist()
    {
        List<Subject> currentSubjectsList = subjectDAO.getSubjects();
        boolean checkSubjectAlreadyExist = false;
        for(Subject subject: currentSubjectsList)
        {
            if(subject.getSubjectName().equals(subjectName.getText()))
            {
                checkSubjectAlreadyExist = true;
                break;
            }
        }
        return checkSubjectAlreadyExist;
    }
}

