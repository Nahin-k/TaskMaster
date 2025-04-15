package taskmasterapp;

import models.User;
import models.Task;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.layout.VBox;
import javafx.scene.control.DatePicker;
import java.time.LocalDate;

public class TaskMasterApp extends Application {

    private User user;

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane(); // Using Pane for absolute positioning

        // Create the TextFields and Buttons
        TextField username = new TextField();
        username.setPromptText("Enter your Username");
        username.setLayoutX(150);
        username.setLayoutY(100);

        // Create the TextFields for creating task
        TextField title = new TextField();
        title.setPromptText("Enter Task Name:");
        title.setLayoutX(150);
        title.setLayoutY(100);

        TextField priority = new TextField();
        priority.setPromptText("Enter priority (1 to 10, 1 being the most and 10 the least):");
        priority.setLayoutX(150);
        priority.setLayoutY(200);

        TextField completion = new TextField();
        completion.setPromptText("Is it completed (true or false):");
        completion.setLayoutX(150);
        completion.setLayoutY(300);

        DatePicker dateCreated = new DatePicker();
        dateCreated.setValue(LocalDate.of(2025, 4, 14));

        TextField password = new TextField();
        password.setPromptText("Enter your Password");
        password.setLayoutX(150);
        password.setLayoutY(200);

        Button login = new Button("Login");
        login.setLayoutX(200);
        login.setLayoutY(300);

        Button signUp = new Button("Sign Up");
        signUp.setLayoutX(150);
        signUp.setLayoutY(250);

        Button CreateTask = new Button("Create Task");
        CreateTask.setLayoutX(150);
        CreateTask.setLayoutY(200);

        Button EditTask = new Button("Edit");
        EditTask.setLayoutX(150);
        EditTask.setLayoutY(250);

        Button ViewTask = new Button("View Tasks");
        ViewTask.setLayoutX(150);
        ViewTask.setLayoutY(300);

        //vbox to create a task
        VBox creatingTask = new VBox(); 
        creatingTask.getChildren().addAll(title, priority, completion, dateCreated);
        creatingTask.setVisible(false);



        // Add styles
        login.getStyleClass().add("glow-button");
        signUp.getStyleClass().add("glow-button");

        // Initially hide login fields
        login.setVisible(false);
        username.setVisible(false);
        password.setVisible(false);
        EditTask.setVisible(false);
        CreateTask.setVisible(false); 

        // Add to pane
        pane.getChildren().addAll(username, password, login, signUp);

        // Sign-up button logic
        signUp.setOnAction(e -> {
            login.setVisible(true);
            username.setVisible(true);
            password.setVisible(true);
            signUp.setVisible(false);
            System.out.println("Sign-up was successful");
        });

        // Login button logic
        login.setOnAction(e -> {
            if (user == null) {
                user = new User();
                user.setUsername(username.getText());
                user.setPassword(password.getText());
                System.out.println("Login was successful");

                pane.getChildren().clear();
                pane.getChildren().addAll(CreateTask, ViewTask);
                CreateTask.setVisible(true);
            } else if (username.getText().equals(user.getUsername()) && user.authenticate(password.getText())) {
                System.out.println("Login was successful");
                pane.getChildren().clear();
            }
        });

        String css = this.getClass().getResource("/assets/default.css").toExternalForm();

        // Create and show the scene
        Scene scene = new Scene(pane, 500, 500);
        scene.getStylesheets().add(css);

        primaryStage.setTitle("TaskMaster App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // Start JavaFX app
    }
}
