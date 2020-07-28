import java.util.ArrayList;
import java.util.Date;

public class Instructor {
    private Integer Id;

    private String Name;
    private String Surname;
    private String PhoneNumber;
    private ArrayList<Integer> Languages;
    private Date StartDate;
    private ArrayList<Department> Departments;
//    private ArrayList<Integer> Days;
//    private ArrayList<Integer> Lessons;
    private int[][] AvailabilityMatrix;

    // Constructors
    public Instructor(String name, String surname, String phoneNumber, ArrayList<Integer> languages, Date startDate, ArrayList<Department> departments, int[][] availabilityMatrix) {
        Name = name;
        Surname = surname;
        PhoneNumber = phoneNumber;
        Languages = languages;
        StartDate = startDate;
        Departments = departments;
//        Days = days;
//        Lessons = lessons;
        AvailabilityMatrix = availabilityMatrix;
    }

    public Instructor() {
    }


    // Getters & Setters
    public void setName(String name) {
        Name = name;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void setLanguages(ArrayList<Integer> languages) {
        Languages = languages;
    }

    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }

    public void setDepartments(ArrayList<Department> departments) {
        Departments = departments;
    }

    public void setAvailabilityMatrix(int[][] availabilityMatrix) {
        AvailabilityMatrix = availabilityMatrix;
    }

    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public ArrayList<Integer> gedLanguages() {
        return Languages;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public ArrayList<Department> getDepartments() {
        return Departments;
    }

    public int[][] getAvailabilityMatrix() {
        return AvailabilityMatrix;
    }

    public String getStartDateToString() { return StartDate.toString();  }

    // Methods
    public void addDepartment(Department dep) {}
}
