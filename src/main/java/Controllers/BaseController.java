package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *  This class is a base class for all the controllers.
 *  Implements Initializable.
 */
public class BaseController implements Initializable {
    protected double xOffset = 0;
    protected double yOffset = 0;
    @FXML
    protected AnchorPane rootPane;
    /**
     * This function let the window be draggable.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        makeStageDraggable();
    }
    /**
     * This function let the window be draggable.
     */
    protected void makeStageDraggable() {
        rootPane.setOnMousePressed((MouseEvent event) -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        rootPane.setOnMouseDragged((MouseEvent event) -> {
            rootPane.getScene().getWindow().setX(event.getScreenX() - xOffset);
            rootPane.getScene().getWindow().setY(event.getScreenY() - yOffset);
        });
    }
    /**
     * This function refresh the AncorPane between to screens.
     *
     * @param url - (String) new screen info.
     *
     * @throws IOException
     */
    protected void refreshPage(String url) throws IOException {
        URL nf = new File(url).toURL();
        Parent root = FXMLLoader.load(nf);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }
}
