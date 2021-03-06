
import Model.UserInput;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

/**
 * The main class in the project. This is where the code should run from.
 */
public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url = new File("src/main/java/Views/UIView.fxml").toURL();
        Parent root = FXMLLoader.load(url);
        primaryStage.setTitle("");
        primaryStage.setScene(new Scene(root,570, 680));
        primaryStage.show();

    }
    public static void main(String[] args) {

        launch(args);
    }

}
