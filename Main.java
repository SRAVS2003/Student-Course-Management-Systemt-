// Student.java (Modified - Add enrollInCourse and getEnrolledCourses)
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CourseManager courseManager = new CourseManager();
        StudentManager studentManager = new StudentManager();
        Admin admin = new Admin(courseManager, studentManager, scanner);

        System.out.print("Enter admin username: ");
        String username = scanner.nextLine();
        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();

        if (username.equals("admin") && password.equals("admin123")) {
            admin.showAdminMenu();
        } else {
            System.out.println("Invalid username or password!");
        }

        scanner.close();
    }
}