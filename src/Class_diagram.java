import java.util.*;

abstract class User {
    protected int id;
    protected String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class University {
    private List<Faculty> faculties = new ArrayList<>();
    public void addFaculty(Faculty f) { faculties.add(f); }
}

class Faculty {
    private String name;
    private List<Department> departments = new ArrayList<>();
    public Faculty(String name) { this.name = name; }
    public void addDept(Department d) { departments.add(d); }
}

class Department {
    private String name;
    public Department(String name) { this.name = name; }
}

class Admin extends User {
    public Admin(int id, String name) { super(id, name); }
    public void manage() { System.out.println("Admin " + name + " updated system."); }
}

class Student extends User {
    public Student(int id, String name) { super(id, name); }
    public void enroll(Course c) { System.out.println("Student " + name + " joined " + c.getTitle()); }
}

class Teacher extends User {
    public Teacher(int id, String name) { super(id, name); }
    public void grade(Student s, int score) { System.out.println("Teacher " + name + " graded " + s.name + score); }
}

class Course {
    private String title;
    public Course(String title) { this.title = title; }
    public String getTitle() { return title; }
}

class Schedule {
    public void set(String time) { System.out.println("Schedule set for " + time); }
}

class Exam {
    private String subject;
    public Exam(String subject) { this.subject = subject; }
    public void run() { System.out.println("Exam " + subject + " in progress."); }
}

public class Class_diagram {
    public static void main(String[] args) {
        Admin tony = new Admin(1, "Tony Stark");
        Student peter = new Student(2, "Peter Parker");
        Teacher strange = new Teacher(3, "Stephen Strange");

        tony.manage();

        Course physics = new Course("Quantum Physics");
        peter.enroll(physics);

        new Schedule().set("09:00 AM");
        new Exam("Quantum Physics").run();

        strange.grade(peter, 100);
    }
}

