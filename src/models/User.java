package models;
import java.util.ArrayList;

public class User {
    protected String username;
    protected String password;
    protected ArrayList<Task> tasks = new ArrayList<>();

    public void setTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }


    public boolean authenticate(String passwordToCheck){
        return passwordToCheck.equals(this.password);
    }
}