import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available!");
        } else {
            System.out.println("\n--- Student List ---");
            for (Student student : students) {
                System.out.println("ID: " + student.getStudentId() + ", Name: " + student.getStudentName());
            }
        }
    }
}