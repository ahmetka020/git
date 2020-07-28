import java.util.ArrayList;

public class Classroom {
    private Integer Id;
    private Integer DepartmentId;
    private ArrayList<Course> Courses;
    private Integer[][] AvailabilityMatrix;

    // Constructors
    public Classroom(Integer departmentId, ArrayList<Course> courses, Integer[][] availabilityMatrix) {
        DepartmentId = departmentId;
        Courses = courses;
        AvailabilityMatrix = availabilityMatrix;
    }

    public Classroom() {
    }

    // Getters & Setter
    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        DepartmentId = departmentId;
    }

    public ArrayList<Course> getCourses() {
        return Courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        Courses = courses;
    }

    public Integer[][] getAvailabilityMatrix() {
        return AvailabilityMatrix;
    }

    public void setAvailabilityMatrix(Integer[][] availabilityMatrix) {
        AvailabilityMatrix = availabilityMatrix;
    }

    // Methods
    public static void ekle(Department dep) {}

    public static void sil(Integer id) {}
}
