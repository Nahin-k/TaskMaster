package taskmasterapp;

import models.User;
import models.Task;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TaskMasterApp extends Application {

    private User user;

    @Override
    public void start(Stage primaryStage) {
        // Create a simple sign-up button
        Button signUp = new Button("Sign Up");

        // Create the TextFields but don't add them to the layout yet
        TextField username = new TextField();
        username.setPromptText("Enter your Username");
        
        TextField password = new TextField();
        password.setPromptText("Enter your Password");

        Button login = new Button("Login");

        // Create a GridPane to hold the TextFields and buttons
        GridPane grid = new GridPane();

        // Add Column and Row Constraints to the input grid
        // Add Column and Row Constraints to the input grid
        for (int i = 0; i < 3; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(100.0 / 3); // Evenly distribute columns
            grid.getColumnConstraints().add(col);
        }
        for (int i = 0; i < 4; i++) {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100.0 / 4); // Evenly distribute rows
            grid.getRowConstraints().add(row);
        }

        grid.setVgap(10); // Vertical gap between rows
        grid.setHgap(10); // Horizontal gap between columns

        // Add the components to the GridPane
        grid.add(username, 1, 1); // column 0, row 0
        grid.add(password, 1, 2); // column 0, row 1
        grid.add(login, 1, 3);    // column 0, row 2
        login.setVisible(false);
        username.setVisible(false);
        password.setVisible(false);
        grid.add(signUp, 1,3);

        // Set the signUp button action
        signUp.setOnAction(e -> {
            login.setVisible(true);
            username.setVisible(true);
            password.setVisible(true); // Make the user input grid visible
            grid.getChildren().remove(signUp); // Remove the signUp button from the root
            System.out.println("Sign-up was successful");
        });

        // Set the login button action
        login.setOnAction(e -> {
            if (user == null) {
                user = new User();
                user.setUsername(username.getText());
                user.setPassword(password.getText());
                System.out.println("Login was successful");
            } else if (username.getText().equals(user.getUsername()) && user.authenticate(password.getText())) {
                System.out.println("Login was successful");
                grid.getChildren().clear(); // Remove all children from the root (clear the UI)
            }
        });

        String css = this.getClass().getResource("/assets/default.css").toExternalForm();

        // Create the scene (adding layout to the window)
        Scene scene = new Scene(grid, 500, 500);
        scene.getStylesheets().add(css);

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
