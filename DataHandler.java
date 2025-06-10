import java.io.*;
import java.util.Map;
import java.util.HashMap;

public class DataHandler {

    private String studentsFilePath;
    private String coursesFilePath;

    public DataHandler(String studentsFilePath, String coursesFilePath) {
        this.studentsFilePath = studentsFilePath;
        this.coursesFilePath = coursesFilePath;
    }

    // --- Student Data Handling ---

    public void saveStudents(Map<String, Student> students) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(studentsFilePath))) {
            oos.writeObject(new HashMap<>(students)); // Write a copy to avoid external modification
            System.out.println("Student data saved to " + studentsFilePath);
        } catch (IOException e) {
            System.err.println("Error saving student data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public Map<String, Student> loadStudents() {
        Map<String, Student> students = new HashMap<>();
        File file = new File(studentsFilePath);
        if (!file.exists()) {
            System.out.println("Student data file not found.  Starting with an empty student list.");
            return students; // Return empty map if file doesn't exist
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(studentsFilePath))) {
            Object obj = ois.readObject();
            if (obj instanceof Map) {
                students = (Map<String, Student>) obj;
                System.out.println("Student data loaded from " + studentsFilePath);
            } else {
                System.err.println("Error: Invalid student data file format.  Starting with an empty student list.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading student data: " + e.getMessage());
            System.err.println("Starting with an empty student list.");
        }
        return students;
    }

    // --- Course Data Handling ---

    public void saveCourses(Map<String, Course> courses) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(coursesFilePath))) {
            oos.writeObject(new HashMap<>(courses)); // Write a copy
            System.out.println("Course data saved to " + coursesFilePath);
        } catch (IOException e) {
            System.err.println("Error saving course data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public Map<String, Course> loadCourses() {
        Map<String, Course> courses = new HashMap<>();
        File file = new File(coursesFilePath);
        if (!file.exists()) {
            System.out.println("Course data file not found.  Starting with an empty course list.");
            return courses; // Return empty map if file doesn't exist
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(coursesFilePath))) {
            Object obj = ois.readObject();
            if (obj instanceof Map) {
                courses = (Map<String, Course>) obj;
                System.out.println("Course data loaded from " + coursesFilePath);
            } else {
                System.err.println("Error: Invalid course data file format. Starting with an empty course list.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading course data: " + e.getMessage());
            System.err.println("Starting with an empty course list.");
        }
        return courses;
    }
}
