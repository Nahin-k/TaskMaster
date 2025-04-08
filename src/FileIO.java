import java.io.*;
import java.util.List;

public class FileIO {

    public static void saveTasks(List<Task> tasks, String username) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(username + "_tasks.txt"))) {
            for (Task task : tasks) {
                writer.write(task.toString());
                writer.newLine();
            }
        }
    }
}