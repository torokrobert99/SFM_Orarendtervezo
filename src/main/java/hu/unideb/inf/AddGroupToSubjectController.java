package hu.unideb.inf;

import hu.unideb.inf.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class AddGroupToSubjectController implements Initializable {


    private JpaSubjectDAO subjectDAO = new JpaSubjectDAO();
    private JpaSubjectGroupDAO subjectGroupDAO = new JpaSubjectGroupDAO();
    private String currentTeacher = Container.currentActivePerson.getName();
    private MainApp m = new MainApp();
    private SubjectGroups currentGroup;


    @FXML
    private ChoiceBox<Integer> timesMenu;

    @FXML
    private ChoiceBox<String> daysMenu;

    @FXML
    private TextField lecturer;

    @FXML
    private ChoiceBox<String> subjectMenu;

    @FXML
    private Label errorMessage;



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
        List<String> days = new ArrayList<>(Arrays.asList("Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek"));
        daysMenu.getItems().addAll(days);
        List<Integer> times = new ArrayList<>(Arrays.asList(8,10,12,14,16,18));
        timesMenu.getItems().addAll(times);
    }
    
    @FXML
    void addGroupButtonPushed(ActionEvent event) throws IOException {
        List<Subject> subjects = subjectDAO.getSubjects();
        boolean fieldsAreEmpty = checkFieldsAreEmpty();
        boolean groupAlreadyExist = checkGroupAlreadyExist();
        if(!fieldsAreEmpty && !groupAlreadyExist)
        {
            for(Subject subject: subjects)
            {
                if(subject.getSubjectName().equals(subjectMenu.getValue()))
                {
                    currentGroup = new SubjectGroups();
                    currentGroup.setOktato(lecturer.getText());
                    currentGroup.setNap(daysMenu.getValue());
                    currentGroup.setIdopont(timesMenu.getValue());
                    subject.setGroups(currentGroup);
                    subjectDAO.saveSubject(subject);
                }
            }
            m.changeScene("/fxml/FXMLMenuScene.fxml");
        }
        else
        {
            errorMessage.setText("Hiba! A fenti mezők kitöltése kötelező!");
        }



    }

    @FXML
    void cancelGroupButtonPushed(ActionEvent event) throws IOException {
        m.changeScene("/fxml/FXMLMenuScene.fxml");
    }

    public boolean checkFieldsAreEmpty()
    {
        return daysMenu.getSelectionModel().isEmpty() || timesMenu.getSelectionModel().toString().isEmpty() || subjectMenu.getSelectionModel().isEmpty() || lecturer.getText().isEmpty();
    }

    public boolean checkGroupAlreadyExist()
    {
        List<SubjectGroups> groups = subjectGroupDAO.getSubjectGroup();
        for(SubjectGroups group: groups)
        {
            if (group.getNap().equals(daysMenu.getValue()) && (group.getIdopont() == timesMenu.getValue()) && group.getOktato().equals(lecturer.getText())){
                return true;
            }
        }
        return false;
    }
}