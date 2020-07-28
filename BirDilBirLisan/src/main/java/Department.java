import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Department {
    private Integer Id;
    private String Name;
    private String Address;
    private String PhoneNumber;
    private String Transport;
    private String SocialOpportunities;
    private ArrayList<Instructor> Instructors;
    private ArrayList<Student> Students;
    private ArrayList<Integer> Languages;
    private ArrayList<Classroom> Classrooms;

    // Constructor //
    public Department(Integer id, String name, String address, String transport, String telephone, String socialOpportunities, ArrayList<Instructor> instructors, ArrayList<Student> students, ArrayList<Integer> languages, ArrayList<Classroom> classrooms) {
        Id = id;
        Name = name;
        Address = address;
        PhoneNumber = telephone;
        Transport = transport;
        SocialOpportunities = socialOpportunities;
        Instructors = instructors;
        Students = students;
        Languages = languages;
        Classrooms = classrooms;
    }

    public Department() {
    }

    // Getters & Setters
    public void setId(Integer id) {
        Id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setTransport(String transport) {
        Transport = transport;
    }

    public void setSocialOpportunities(String socialOpportunities) {
        SocialOpportunities = socialOpportunities;
    }

    public void setInstructors(ArrayList<Instructor> instructors) {
        Instructors = instructors;
    }

    public void setStudents(ArrayList<Student> students) {
        Students = students;
    }

    public void setLanguages(ArrayList<Integer> languages) {
        Languages = languages;
    }

    public void setClassrooms(ArrayList<Classroom> classrooms) {
        Classrooms = classrooms;
    }

    public void setPhoneNumber(String phoneNumber) { PhoneNumber = phoneNumber; }

    public String getPhoneNumber() { return PhoneNumber; }

    public Integer getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getAddress() {
        return Address;
    }

    public String getTransport() {
        return Transport;
    }

    public String getSocialOpportunities() {
        return SocialOpportunities;
    }

    public ArrayList<Instructor> getInstructors() {
        return Instructors;
    }

    public ArrayList<Student> getStudents() {
        return Students;
    }

    public ArrayList<Integer> getLanguages() {
        return Languages;
    }

    public ArrayList<Classroom> getClassrooms() {
        return Classrooms;
    }

    // Methods
//    Departman Ekleme Ana Öykü:
//
//      1.  Sistem yöneticisi departman kalemini oluşturur.
//      2.  Sistem yöneticisi departmanın isim, adres, telefon bilgilerini ekler.
//      3.  Sistem yöneticisi departmana derslikleri ekler (Kullanım Öyküsü: Derslik Ekleme)
//      4.  Sistem yöneticisi departmanda verilecek derslerin tablosunu oluşturur ve departman kalemine ekler.
//      5.  Sistem elemanı için gereken görüntüleme ve ulaşılabilirlik sağlanmış olur.

//    public class Department {
//        private Integer Id;
//        private String Name;
//        private String Address;
//        private String Transport;
//        private String SocialOpportunities;
//        private ArrayList<Instructor> Instructors;
//        private ArrayList<Student> Students;
//        private ArrayList<Integer> Languages;
//        private ArrayList<Classroom> Classrooms;

    public static void ekle() {

        Scanner in = new Scanner(System.in);
        System.out.println(" > Departman Oluşturuluyor <");
        Department newDep = new Department();

        System.out.print(" > Departman adını giriniz: ");
        newDep.setName( in.nextLine() );

        System.out.print(" > Departmanın adres bilgilerini giriniz: ");
        newDep.setAddress( in.nextLine() );

        while(true) {
            System.out.print(" > Departmanın telefon numarası (12 karakterli): +");
            String tel = in.nextLine();
            if( tel.length() == 12 ) {
                newDep.setPhoneNumber(tel);
                break;
            } else {
                System.out.println(" ! 12 karakterli olmasına dikkat ediniz!");
            }
        }

        ArrayList<Instructor> ortmenler = new ArrayList<Instructor>();
        Instructor ortmen = new Instructor();
        ortmen.addDepartment(newDep);
        ortmenler.add(ortmen);
        newDep.setInstructors( ortmenler );

        newDep.addLanguages(ortmen.gedLanguages());

        ArrayList<Classroom> siniflar = new ArrayList<Classroom>();
        Classroom sinif = new Classroom();
        newDep.addClassroom(sinif);



        // Database kayıt
        DbConnection db = new DbConnection();
        db.initialize();

        try {
            db.insertDepartment(newDep);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        db.close_connection();

        System.out.println(" > " + newDep.getName() + " departmani başarıyla oluşturuldu!");
        System.out.println(" > Devam etmek için Enter'a basınız");
        try{System.in.read();}
        catch(Exception e){}
        //in.close();

    }

    public static void sil() {

        Scanner in = new Scanner(System.in);
        System.out.print(" >Silmek istediğiniz departmanın ID'sini giriniz: ");
        int id = in.nextInt();

        DbConnection db = new DbConnection();
        db.initialize();
        db.deleteDepartment(id);
        db.close_connection();

        System.out.println(" > " + id + " id'li öğrencinin kaydı sistemden başarıyla silindi! ");
        System.out.println(" > Devam etmek için Enter'a basınız");
        try{System.in.read();}
        catch(Exception e){}
        //in.close();
    }

    public void addLanguages(ArrayList<Integer> diller) {}

    public void addClassroom(Classroom sinif) {}
}
