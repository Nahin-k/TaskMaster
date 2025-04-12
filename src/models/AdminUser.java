package models;

import java.util.ArrayList;

public class AdminUser extends User {
    private ArrayList<Task> tasks;  // ✅ now correctly inside the class

    public AdminUser(String username, String password, ArrayList<Task> tasks) {
        super();
        this.tasks = tasks; // assign passed-in tasks
    }

    public void clearAllTasks() {
        tasks.clear();
    }
}
