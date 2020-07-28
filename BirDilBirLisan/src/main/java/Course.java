import java.util.ArrayList;

public class Course {
    private Integer Id;
    private Integer Language;
    private Integer Level;
    private Classroom Classroom;
    private Instructor Instructor;
    private ArrayList<Student> EnrolledStudents;
    private int[][] courseTime;

    // Constructors
    public Course(Integer language, Integer level, Classroom classroom, Instructor instructor, ArrayList<Student> enrolledStudents, int courseTime) {
        Language = language;
        Level = level;
        Classroom = classroom;
        Instructor = instructor;
        EnrolledStudents = enrolledStudents;
        courseTime = courseTime;
    }

    public Course() {
    }

    // Getters & Setters
    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getLanguage() {
        return Language;
    }

    public void setLanguage(Integer language) {
        Language = language;
    }

    public Integer getLevel() {
        return Level;
    }

    public void setLevel(Integer level) {
        Level = level;
    }

    public Classroom getClassroom() {
        return Classroom;
    }

    public void setClassroom(Classroom classroom) {
        Classroom = classroom;
    }

    public Instructor getInstructor() {
        return Instructor;
    }

    public void setInstructor(Instructor instructor) {
        Instructor = instructor;
    }


    public ArrayList<Student> getEnrolledStudents() {
        return EnrolledStudents;
    }

    public void setEnrolledStudents(ArrayList<Student> enrolledStudents) {
        EnrolledStudents = enrolledStudents;
    }

    public int[][] getCourseTime() { return courseTime;
    }

    // Methods
    public static void ekle(Classroom sinif) {}

    public static void sil(Integer id) {}

    public void addStudent(Integer id) {}

    public static Course findCourse() { return new Course(); }
}
