package hu.unideb.inf;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;


public class MainApp extends Application {
    private static Stage stg;

    @Override
    public void start(Stage stage) throws Exception {
        stg = stage;
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/FXMLOrarendScene.fxml"));
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
    public static void main(String[] args) {
        launch(args);
    }

}
