
import java.util.Scanner;

public class Admin {
    private CourseManager courseManager;
    private StudentManager studentManager;
    private Scanner scanner;

    public Admin(CourseManager courseManager, StudentManager studentManager, Scanner scanner) {
        this.courseManager = courseManager;
        this.studentManager = studentManager;
        this.scanner = scanner;
    }

    public void showAdminMenu() {
        int choice;
        do {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Add Course");
            System.out.println("2. View All Courses");
            System.out.println("3. Add Student");
            System.out.println("4. View All Students");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    System.out.print("Enter Course ID: ");
                    String courseId = scanner.nextLine();
                    System.out.print("Enter Course Name: ");
                    String courseName = scanner.nextLine();
                    courseManager.addCourse(new Course(courseId, courseName));
                    break;
                case 2:
                    courseManager.viewCourses();
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String studentName = scanner.nextLine();
                    studentManager.addStudent(new Student(studentId, studentName));
                    break;
                case 4:
                    studentManager.viewStudents();
                    break;
                case 5:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }
}