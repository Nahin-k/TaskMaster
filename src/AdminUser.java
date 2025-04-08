import java.util.ArrayList;

public class AdminUser extends User {

    public AdminUser(String username, String password, ArrayList<Task> tasks) {
        super(username, password, tasks);
    }

    public void clearAllTasks() {
        tasks.clear();
    }
}