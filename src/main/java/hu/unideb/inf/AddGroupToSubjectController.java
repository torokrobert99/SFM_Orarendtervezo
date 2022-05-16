package hu.unideb.inf;

import hu.unideb.inf.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AddGroupToSubjectController implements Initializable {


    private JpaSubjectDAO subjectDAO = new JpaSubjectDAO();
    private String currentTeacher = Container.currentActivePerson.getName();
    private MainApp m = new MainApp();
    private SubjectGroups currentGroup;
    @FXML
    private TextField day;

    @FXML
    private TextField lecturer;

    @FXML
    private ChoiceBox<String> subjectMenu;


    @FXML
    private TextField time;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Subject> subjects = subjectDAO.getSubjects();
        for(Subject subject: subjects)
        {
            if(subject.getTargyfelelos().equals(currentTeacher))
            {
                subjectMenu.getItems().add(subject.getSubjectName());
            }
        }

    }
    @FXML
    void addGroupButtonPushed(ActionEvent event) throws IOException {
        List<Subject> subjects = subjectDAO.getSubjects();
        for(Subject subject: subjects)
        {
            if(subject.getSubjectName().equals(subjectMenu.getValue()))
            {
                currentGroup = new SubjectGroups();
                currentGroup.setOktato(lecturer.getText());
                currentGroup.setNap(day.getText());
                currentGroup.setIdopont(Integer.parseInt(time.getText()));
                subject.setGroups(currentGroup);
                subjectDAO.saveSubject(subject);
            }
        }
        m.changeScene("/fxml/FXMLMenuScene.fxml");

    }

    @FXML
    void cancelGroupButtonPushed(ActionEvent event) throws IOException {
        m.changeScene("/fxml/FXMLMenuScene.fxml");
    }


}