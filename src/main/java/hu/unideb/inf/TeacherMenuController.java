package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TeacherMenuController implements Initializable{
    MainApp m = new MainApp();
    @FXML
    private Label loggedName;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //loggedName.setText();
    }

    @FXML
    void addSubjectButtonPushed(ActionEvent event) {

    }

    @FXML
    void logOutButtonPushed(ActionEvent event) throws IOException {
        m.changeScene("/fxml/FXMLOrarendScene.fxml");
    }

    @FXML
    void subjectButtonPushed(ActionEvent event) {

    }
}
