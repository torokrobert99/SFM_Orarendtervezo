package hu.unideb.inf;
import hu.unideb.inf.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import hu.unideb.inf.model.*;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class MySubjectListController implements Initializable {
    MainApp m = new MainApp();
    JpaMySubjectsDAO MysubjectsDAO = new JpaMySubjectsDAO();

    @FXML
    private Button backButton;

    @FXML
    private ListView<String> mySubjectsList;

    @FXML
    void backButtonPushed(ActionEvent event) throws IOException {
        m.changeScene("/fxml/FXMLMenuScene.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        List<MySubjects> data = MysubjectsDAO.getMySubjects();
        Set<String> li = new HashSet();
        for (MySubjects line : data) {
            if(Container.currentActivePerson.getId() == line.getStudent_id())
            {
                li.add(line.getSubject() + ": " + line.getNap() +" "+ line.getOra() + ":00-");
            }

        }

        mySubjectsList.getItems().addAll(li);

    }
}
