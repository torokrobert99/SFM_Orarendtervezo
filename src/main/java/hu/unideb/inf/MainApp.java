package hu.unideb.inf;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;
import java.sql.SQLException;

import org.h2.tools.Server;


public class MainApp extends Application {
    private static Stage stg;

    @Override
    public void start(Stage stage) throws Exception {
        stg = stage;
        //new Server().runTool("-tcp", "-web", "-ifNotExists");
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/FXMLLoginScene.fxml"));
        Scene scene = new Scene(loader.load());
        stg.setTitle("Orarendtervezo");
        stg.setScene(scene);
        stg.show();
    }


    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
        stg.getScene().setRoot(pane);
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
            startDatabase(); // start h2 database
        /*  try (JpaPersonDAO aDAO = new JpaPersonDAO();) { // JpaPersonDAO helyett FilePersonDAO ha szerializáció kell
            Student a = new Student();
            a.setName("Példa Péter");
            a.setAge(21);
            a.setRole(Person.RoleType.STUDENT);
            a.setUsername("peldapeter99");
            a.setPassword("alma123");
            aDAO.savePerson(a); //kaszkádolás, lásd School.java

            Student s = new Student();
            s.setName("Gipsz Jakab");
            s.setAge(22);
            s.setRole(Person.RoleType.STUDENT);
            aDAO.savePerson(s);

            Teacher t = new Teacher();
            t.setName("Kósa Márk");
            t.setAge(50);
            t.setRole(Person.RoleType.TEACHER);
            t.setUsername("kosamark22");
            t.setPassword("xddd");
            aDAO.savePerson(t);
            /* School school = new School();
            school.setName("Debreceni Egyetem");
            school.getPersons().add(a);
            aDAO.saveSchool(school);
        } catch (Exception e) {
            e.printStackTrace();
        } */
        launch(args);

    }

    private static void startDatabase() throws SQLException {
        new Server().runTool("-tcp", "-web", "-ifNotExists");
    }
}
