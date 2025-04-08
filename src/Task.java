import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Task {
    private String title;
    private int priority;
    private boolean completed;
    private LocalDateTime dateCreated;


    public Task(String title, int priority, boolean completed, LocalDateTime dateCreated) {
        this.title = title;
        this.priority = priority;
        this.completed = completed;
        this.dateCreated = dateCreated;
    }

    public String getTitle() {
        return title;
    }

    public int getPriority() {
        return priority;
    }

    public boolean getCompleted() {
        return completed;
    }

    public LocalDateTime getDateCreated(){
        return dateCreated;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setDateCreated(LocalDateTime dateCreated){
        this.dateCreated = dateCreated;
    }

    @Override
    public int hashCode(){
        return Objects.hash(title, priority, completed, dateCreated);
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }else if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Task other = (Task) obj;
        return Objects.equals(title, other.title) &&
               priority == other.priority &&
               completed == other.completed &&
               Objects.equals(dateCreated, other.dateCreated);
    }

    @Override
    public String toString() {
        return priority + ": " + title;
    }

    public Task compare(Task other){
        if (this.priority > other.priority){
            return this;
        }
        else if(this.priority < other.priority){
            return other;
        }
        else{
            return this;
        }
    }
}