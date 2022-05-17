package hu.unideb.inf;

import hu.unideb.inf.model.*;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TargyfelvetelController implements Initializable {
    MainApp m = new MainApp();

    JpaSubjectDAO subjectDAO = new JpaSubjectDAO();
    JpaSubjectGroupDAO subjectGroupDAO = new JpaSubjectGroupDAO();
    final String[] currentSubject = new String[1];
    final String[] currentGroup = new String[1];

    @FXML
    private Button backButton;

    @FXML
    private Button felveszButton;

    @FXML
    private ListView<String> mySubjectsList;

    @FXML
    private ListView<String> subjectList;

    @FXML
    private ListView<String> timestampList;

    @FXML
    void backButtonPushed(ActionEvent event) throws IOException {
        m.changeScene("/fxml/FXMLMenuScene.fxml");
    }

    @FXML
    void felveszButtonPushed(ActionEvent event) throws IOException {
        System.out.println(currentSubject[0] + " " + currentGroup[0]);
        //TODO
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Subject> subjects = subjectDAO.getSubjects();
        List<SubjectGroups> times = subjectGroupDAO.getSubjectGroup();
        List<String> subjs = new ArrayList<>();

        for (Subject subject : subjects) {
            //subjectList.getItems().add(subject.getSubjectName());
            subjs.add(subject.getSubjectName());
        }

        subjectList.getItems().addAll(subjs);

        subjectList.getSelectionModel().selectedItemProperty().addListener(
                (var, oldValue, newValue) -> {
                    currentSubject[0] = subjectList.getSelectionModel().getSelectedItem();
                    timestampList.getItems().clear();
                    for (SubjectGroups subject : times) {
                        if (currentSubject[0] == subject.getSubject().getSubjectName()) {

                            timestampList.getItems().add(subject.getNap() + " " + subject.getIdopont());
                            timestampList.getSelectionModel().selectedItemProperty().addListener(
                                    (var2,oldValue2,newValue2) -> {
                                        currentGroup[0] = timestampList.getSelectionModel().getSelectedItem();
                                    }
                            );
                        }

                    }

                }
        );




        /*for (SubjectGroups subjectGroups : times) {

            if (subjectGroups.getSubject().getSubjectName()=="")
            {
                subjectList.getItems().add(subjectGroups.getNap() + " " + subjectGroups.getIdopont());
            }
        }*/
    }
}
