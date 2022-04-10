package hu.unideb.inf;

import hu.unideb.inf.model.*;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RegisterSceneController {
    private Model model;
    public void setModel(Model model) {this.model = model;}
    JpaPersonDAO personDAO = new JpaPersonDAO();
    JpaTeacherDAO teacherDAO = new JpaTeacherDAO();
    JpaStudentDAO studentDAO = new JpaStudentDAO();
    MainApp m = new MainApp();

    @FXML
    private PasswordField confirmpasswordInRegister;

    @FXML
    private Label errorMessage;

    @FXML
    private TextField firstnameTextField;

    @FXML
    private PasswordField passwordInRegister;

    @FXML
    private TextField secondnameTextField;

    @FXML
    private RadioButton studentButton;

    @FXML
    private RadioButton teacherButton;

    @FXML
    private TextField usernameInRegister;


    /**
     * Visszatér a bejelentkező felülethez, ha megnyomjuk a mégse gombot
     */
    @FXML
    void cancelButtonPushed(ActionEvent event) throws IOException {
        m.changeScene("/fxml/FXMLOrarendScene.fxml");

    }

    /**
     * Hozzáadja az adatbázishoz a megfelelő példányt
     */
    @FXML
    void sendingButtonPushed(ActionEvent event) throws IOException {
        boolean checkFields = areTextFieldsEmpty();
        boolean checkPasswords = comparePasswords();
        boolean checkUsername = isUsernameTaken();
        if (studentButton.isSelected() && !checkPasswords && !checkFields && !checkUsername) {
            Student registerStudent = new Student();
            registerStudent.setName(secondnameTextField.getText() + " " + firstnameTextField.getText());
            registerStudent.setRole(Person.RoleType.STUDENT);
            registerStudent.setUsername(usernameInRegister.getText());
            registerStudent.setPassword(passwordInRegister.getText());
            personDAO.savePerson(registerStudent);
            changeSceneToAfterRegister();
        }
        else if (teacherButton.isSelected()  && !checkPasswords && !checkFields)
        {
            Teacher registerTeacher = new Teacher();
            registerTeacher.setName(secondnameTextField.getText() + " " + firstnameTextField.getText());
            registerTeacher.setRole(Person.RoleType.TEACHER);
            registerTeacher.setUsername(usernameInRegister.getText());
            registerTeacher.setPassword(passwordInRegister.getText());
            personDAO.savePerson(registerTeacher);
            changeSceneToAfterRegister();


        }
        else if (checkFields)
        {
            errorMessage.setText("Hiba! A fenti mezők kitöltése kötelező!");
        }
        else if (checkPasswords)
        {
            errorMessage.setText("Hiba! A jelszavaknak meg kell egyeznie!");
        }
        else if (checkUsername)
        {
            errorMessage.setText("Hiba! A felhasználónév foglalt!");
        }

    }

    /**
     * Ez a metódus megnézi hogy a megadott jelszavak egyeznek-e
     */
    public boolean comparePasswords()
    {
        return !(passwordInRegister.getText().equals(confirmpasswordInRegister.getText()) &&
                !(passwordInRegister.getText().isEmpty()) && !(confirmpasswordInRegister.getText().isEmpty()));
    }

    /**
     * Megnézi hogy a megadott felhasználónév foglalt-e ha igen true értékkel tér vissza, ha nem akkor false
     */
    public boolean isUsernameTaken()
    {
        boolean resultStudent = false;
        boolean resultTeacher = false;
        String compareUsername = usernameInRegister.getText();
        List<Teacher> listOfTeachersToCompare = teacherDAO.getTeachers();
        List<Student> listOfStudentsToCompare = studentDAO.getStudents();
        for(Student student: listOfStudentsToCompare)
        {
            if(student.getUsername().equals(compareUsername))
            {
                resultStudent = true;
                break;
            }
        }
        for(Teacher teacher: listOfTeachersToCompare)
        {
            if(teacher.getUsername().equals(compareUsername))
            {
                resultTeacher = true;
                break;
            }
        }
        return resultStudent || resultTeacher;

    }

    /**
     * Ellenőrzi hogy a mezők üresek-e
     */
     public boolean areTextFieldsEmpty()
    {
        return firstnameTextField.getText().isEmpty() || secondnameTextField.getText().isEmpty() || usernameInRegister.getText().isEmpty();
    }

    public void changeSceneToAfterRegister() throws IOException {

        m.changeScene("/fxml/FXMLAfterRegisterScene.fxml");

    }




}
