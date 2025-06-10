import java.util.ArrayList;
import java.util.List;

public class CourseManager {
    private List<Course> courses;

    public CourseManager() {
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
        System.out.println("Course added successfully!");
    }

    public void viewCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available!");
        } else {
            System.out.println("\n--- All Courses ---");
            for (Course course : courses) {
                System.out.println(course);
            }
        }
    }
}
