package Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Course.Course;


public class CourseRegistrationSystem {
    private List<Course> courses;
    private String name;

    public String getName() {
        return name;
    }

    public CourseRegistrationSystem() {
        this.courses = new ArrayList<>();
    }

    public void registerCourse(Course course) {
        if (course.getCurrentEnrollment() < course.getMaxCapacity()) {
            course.setCurrentEnrollment(course.getCurrentEnrollment() + 1);
            System.out.println("Registration successful.");
        } else {
            System.out.println("Course is full. Registration failed.");
        }
    }

    public void displayCourseInformation() {
        System.out.println("Available courses:");
        for (Course course : courses) {
            System.out.println("Course ID: " + course.getCourseId());
            System.out.println("Course Name: " + course.getCourseName());
            System.out.println("Current Enrollment: " + course.getCurrentEnrollment());
            System.out.println("Max Capacity: " + course.getMaxCapacity());
            System.out.println("------------------------------------------------------------------");
        }
    }

    public static void main(String[] args) {
        CourseRegistrationSystem registrationSystem = new CourseRegistrationSystem();
        Course course1 = new Course("CS50", "Introduction to Computer Science (Harvard University)", 30);
        Course course2 = new Course("CS49", "Artificial Intelligenceg", 25);
        Course course3 = new Course("CS48", "Operating Systems", 25);
        Course course4 = new Course("CS47", "Networking", 3);
        Course course5 = new Course("CS46", "Information Science", 15);
        Course course6 = new Course("CS45", "Theory, Logic and Design", 32);
        Course course7 = new Course("CS44", "Applied Computer Science", 27);
        Course course8 = new Course("CS43", "Algorithms, Data structures", 18);
        Course course9 = new Course("CS42", "Programming languages, Compilers", 22);
        Course course10 = new Course("CS41", "Computational science", 26);

        registrationSystem.courses.add(course1);
        registrationSystem.courses.add(course2);
        registrationSystem.courses.add(course3);
        registrationSystem.courses.add(course4);
        registrationSystem.courses.add(course5);
        registrationSystem.courses.add(course6);
        registrationSystem.courses.add(course7);
        registrationSystem.courses.add(course8);
        registrationSystem.courses.add(course9);
        registrationSystem.courses.add(course10);


        Scanner scanner = new Scanner(System.in);

        while (true) {
        	 System.out.println("____________________________________________________________________________________________________________________________________");
           
        	 
        	 System.out.println("1. Register for a course.");
            System.out.println("2. Display course information.");
            System.out.println("3. Exit.");
            System.out.println("____________________________________________________________________________________________________________________________________");
            
            
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            System.out.println("____________________________________________________________________________________________________________________________________");
            scanner.nextLine();
          

            switch (choice) {
                case 1:
                    System.out.print("Enter the Student Name : ");
                    String name = scanner.nextLine();
                    System.out.print("Enter the course ID: ");
                    String courseId = scanner.nextLine();
                    Course selectedCourse = null;
                    for (Course course : registrationSystem.courses) {
                        if (course.getCourseId().equals(courseId)) {
                            selectedCourse = course;
                            break;
                        }
                    }
                    if (selectedCourse != null) {
                        registrationSystem.registerCourse(selectedCourse);
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;
                case 2:
                    registrationSystem.displayCourseInformation();
                    break;
                case 3:
                    System.out.println("Exiting the program.Thank You, Visit Again");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}