package hu.unideb.inf;

import hu.unideb.inf.model.JpaSubjectDAO;
import hu.unideb.inf.model.JpaSubjectGroupDAO;
import hu.unideb.inf.model.Subject;
import hu.unideb.inf.model.SubjectGroups;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SubjectListController implements Initializable {

    private JpaSubjectDAO subjectDAO = new JpaSubjectDAO();
    private JpaSubjectGroupDAO groupDAO = new JpaSubjectGroupDAO();
    private MainApp m = new MainApp();
    final Subject[] currentSubject = new Subject[1];

    @FXML
    private ListView<SubjectGroups> listOfGroups;

    @FXML
    private ListView<Subject> listOfSubjects;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listOfSubjects.getItems().addAll(subjectDAO.getSubjects());


        listOfSubjects.getSelectionModel().selectedItemProperty().addListener(
                (var, oldValue, newValue) -> {
                    currentSubject[0] = listOfSubjects.getSelectionModel().getSelectedItem();
                    listOfGroups.getItems().clear();
                    for (SubjectGroups subject : groupDAO.getSubjectGroup()) {
                        if (currentSubject[0].getSubjectName().equals(subject.getSubject().getSubjectName())) {

                            listOfGroups.getItems().add(subject);;
                        }
                    }

                });
    }

    @FXML
    void backButtonPushed(ActionEvent event) throws IOException {
        m.changeScene("/fxml/FXMLMenuScene.fxml");
    }
}
