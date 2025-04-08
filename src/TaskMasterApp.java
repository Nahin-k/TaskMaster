import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TaskMasterApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a simple sign-up button
        Button signUp = new Button("Sign Up");

        // Set the button action to show the TextFields
        signUp.setOnAction(e -> {
            // Create the TextFields but don't add them to the layout yet
            TextField username = new TextField();
            username.setPromptText("Enter your Username");
            
            TextField password = new TextField();
            password.setPromptText("Enter your Password");

            // Create a VBox to hold the TextFields and button
            VBox vbox = new VBox(10);  // Vertical box with a 10-pixel spacing
            vbox.getChildren().addAll(username, password);
            // When the sign-up button is clicked, add TextFields to the layout
            vbox.setVisible(true);  // Make the VBox visible with the TextFields
        });

        // Create the root layout as a StackPane
        StackPane root = new StackPane();
        root.getChildren().addAll(signUp);  // Add both the button and VBox

        // Create the scene (adding layout to the window)
        Scene scene = new Scene(root, 300, 250);

        // Set the title of the window
        primaryStage.setTitle("TaskMaster App");
        primaryStage.setScene(scene);

        // Show the window
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);  // Start the JavaFX application
    }
}
