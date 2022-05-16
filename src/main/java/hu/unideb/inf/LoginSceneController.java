package hu.unideb.inf;

import hu.unideb.inf.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class LoginSceneController implements Initializable {
    private Model model;
    Parent root;

    public void setModel(Model model) {
        this.model = model;
    }

    //JpaPersonDAO personDAO = new JpaPersonDAO();
    JpaTeacherDAO teacherDAO = new JpaTeacherDAO();
    JpaStudentDAO studentDAO = new JpaStudentDAO();
    MainApp m = new MainApp();


    @FXML
    private Label errorMessage;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    private Button registerButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //TODO

    }

    /**
     * Ez a belépő gomb, ami továbbit a Menühöz ha a feltételek megfelelnek.
     */
    @FXML
    void handledLoginButtonPushed(ActionEvent event) throws IOException {
        boolean checkFields = areTextFieldsEmpty();

        if (checkFields) {
            errorMessage.setText("Hiba! A fenti mezők kitöltése kötelező!");
        } else {

            loginAttempt();


        }

    }

    /**
     * Ez a gonb kódja ami átvisz a regisztrációhoz.
     */
    @FXML
    void handledRegisterButtonPushed(ActionEvent event) throws IOException {
        MainApp m = new MainApp();
        m.changeScene("/fxml/FXMLRegisterScene.fxml");

    }

    /**
     * Ez a metódus megnézi hogy üressek-e a belépési mezők.
     */

    public boolean areTextFieldsEmpty() {
        return passwordField.getText().isEmpty() || usernameField.getText().isEmpty();
    }

    /**
     * Ez a metódus ellenőrzi a megadott bejelentkezési adatokat, és vissza tér a megadott felhasználóval.
     */
    public String loginAttempt() throws IOException {
        MainApp m = new MainApp();
        boolean validUser = false;
        String compareUsername = usernameField.getText();
        String comparePassword = passwordField.getText();
        List<Teacher> listOfTeachersToCompare = teacherDAO.getTeachers();
        List<Student> listOfStudentsToCompare = studentDAO.getStudents();
        for (Student student : listOfStudentsToCompare) {
            if (student.getUsername().equals(compareUsername)) {
                validUser = true;
                if (student.getPassword().equals(comparePassword)) {
                    compareUsername = student.getUsername();
                    m.changeScene("/fxml/FXMLMenuScene.fxml");
                }
            }
        }
        for (Teacher teacher : listOfTeachersToCompare) {
            if (teacher.getUsername().equals(compareUsername)) {
                validUser = true;
                if (teacher.getPassword().equals(comparePassword)) {
                    compareUsername = teacher.getUsername();
                    Container.currentActivePerson = teacher;
                    m.changeScene("/fxml/FXMLMenuScene.fxml");
                }
            }
        }
        if (!validUser) {
            errorMessage.setText("A megadott felhasználónév vagy jelszó helytelen!");
        }
        return compareUsername;
    }
}
