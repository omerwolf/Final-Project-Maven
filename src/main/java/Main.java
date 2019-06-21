
import Model.UserInput;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

/**
 * the main class in the project. this is where the code should run from
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
/**

// Java  Program to create a ChoiceBox and add listener to it.
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.collections.*;
import javafx.beans.value.*;
import javafx.stage.Stage;
public class Main extends Application {

    // launch the application
    public void start(Stage s)
    {
        // set title for the stage
        s.setTitle("creating ChoiceBox");

        // create a button
        Button b = new Button("show");

        // create a tile pane
        TilePane r = new TilePane();

        // create a label
        Label l = new Label("This is a choice box");
        Label l1 = new Label("nothing selected");

        // string array
        String st[] = { "Arnab", "Andrew", "Ankit", "None" };

        // create a choiceBox
        ChoiceBox c = new ChoiceBox(FXCollections.observableArrayList(st));

        // add a listener
        c.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            // if the item of the list is changed
            public void changed(ObservableValue ov, Number value, Number new_value)
            {

                // set the text for the label to the selected item
                l1.setText(st[new_value.intValue()] + " selected");
            }
        });

        // add ChoiceBox
        r.getChildren().add(l);
        r.getChildren().add(c);
        r.getChildren().add(l1);

        // create a scene
        Scene sc = new Scene(r, 200, 200);

        // set the scene
        s.setScene(sc);

        s.show();
    }

    public static void main(String args[])
    {
        // launch the application
        launch(args);
    }
}
 */