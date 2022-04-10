package hu.unideb.inf;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AfterRegisterSceneController implements Initializable {

    private Timeline timeline;
    MainApp m = new MainApp();
    @FXML
    private Button backToLoginSceneButton;

    /**
     * Manuálisan vissza lehet térni a bejelentkező felületre
     */
    @FXML
    void backToLoginButtonPushed(ActionEvent event) throws IOException {
        timeline.stop();
        m.changeScene("/fxml/FXMLOrarendScene.fxml");
    }

    /**
     * Ez a initializeable interfésznek egy metódusa, lényegében segít abban,
     * metódusokat hívjunk meg grafikus elem társítása nélkül
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            backToLoginScene();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /***
     Automatikusan Scenet vált 5 mp után a bejelentkező felületre
     */
    public void backToLoginScene() throws IOException
    {
        System.out.println("Hello");
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(5),actionEvent -> {
                    try {
                        m.changeScene("/fxml/FXMLOrarendScene.fxml");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                })
        );
        timeline.play();


    }
}





