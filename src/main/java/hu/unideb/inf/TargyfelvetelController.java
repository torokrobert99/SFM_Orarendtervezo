package hu.unideb.inf;

import hu.unideb.inf.model.*;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class TargyfelvetelController implements Initializable {
    MainApp m = new MainApp();

    JpaSubjectDAO subjectDAO = new JpaSubjectDAO();
    JpaMySubjectsDAO MysubjectsDAO = new JpaMySubjectsDAO();
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
    private Label errorMessage;

    @FXML
    void backButtonPushed(ActionEvent event) throws IOException {
        m.changeScene("/fxml/FXMLMenuScene.fxml");
    }

    @FXML
    void felveszButtonPushed(ActionEvent event) throws IOException
    {
        List<MySubjects> exist = MysubjectsDAO.getMySubjects();
        boolean bennevan = false;

        for (MySubjects i:exist)
        {
            if(Container.currentActivePerson.getId() == i.getStudent_id() && i.getSubject().equals(currentSubject[0]))
            {
                bennevan = true;
            }
        }
        if(bennevan)
        {
            errorMessage.setText("Hiba! Ilyen tárgyat már vettél fel!");
        }
        else
        {
            MySubjects felvettTargy = new MySubjects();
            felvettTargy.setStudent_id(Container.currentActivePerson.getId());
            felvettTargy.setSubject(currentSubject[0]);
            String[]tokens = currentGroup[0].split(" ");
            felvettTargy.setNap(tokens[0]);
            felvettTargy.setOra(tokens[1]);
            MysubjectsDAO.saveMySubjects(felvettTargy);
        }
        }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Subject> subjects = subjectDAO.getSubjects();
        List<SubjectGroups> times = subjectGroupDAO.getSubjectGroup();
        List<MySubjects> my = MysubjectsDAO.getMySubjects();
        List<String> subjs = new ArrayList<>();
        Set<String> mySubjs = new HashSet<>();

        for (MySubjects mys : my)
        {
            if(Container.currentActivePerson.getId() == mys.getStudent_id())
            {
                mySubjs.add(mys.getSubject());
            }

        }

        mySubjectsList.getItems().addAll(mySubjs);


        for (Subject subject : subjects) {
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
    }
}
