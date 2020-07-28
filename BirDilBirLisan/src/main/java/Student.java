import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private Integer Id;
    private String Name;
    private String Surname;
    private String PhoneNumber;
    private Float Debt;
    private Integer Installment = 0;
    private ArrayList<Course> Courses;

    // Constructors
    public Student(String name, String surname, String phoneNumber, Float debt, Integer installment, ArrayList<Course> courses) {
        Name = name;
        Surname = surname;
        PhoneNumber = phoneNumber;
        this.Debt = debt;
        Installment = installment;
        Courses = courses;
    }

    public Student() {
    }

    // Getters & Setters
    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public Float getDebt() {
        return Debt;
    }

    public void setDebt(Float debt) {
        Debt = debt;
    }

    public Integer getInstallment() {
        return Installment;
    }

    public void setInstallment(Integer installment) {
        Installment = installment;
    }

    public ArrayList<Course> getCourses() {
        return Courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        Courses = courses;
    }

    // Methods
    public static void ekle(){

        Scanner in = new Scanner(System.in);
        System.out.println(" > Öğrenci kaydı oluşturuluyor < ");
        Student newStudent = new Student();

        System.out.print(" > Öğrencinin adı: ");
        newStudent.setName(in.nextLine());

        System.out.print(" > Öğrencinin soyadı: ");
        newStudent.setSurname(in.nextLine());

        while(true) {
            System.out.print(" > Öğrencinin telefon numarası (12 karakterli): +");
            String tel = in.nextLine();
            if(tel.length() == 12 ) {
                newStudent.setPhoneNumber(tel);
                break;
            } else {
                System.out.println("   ! 12 karakterli olmasına dikkat ediniz!");
            }
        }

        ArrayList<Course> courses = new ArrayList<Course>();
        float money = 0;
        int donguSayisi = 0;
        String kursRaw;
        int kurss;
        String[] kursTable = {"Türkçe", "İngilizce", "Almanca", "Arapça", "İspanyolca",
                                "Rusça", "Çince", "Fransızca"};
        System.out.println(" > Kayıt edilecek dilleri teker teker giriniz: " +
                "\n  0) Türkçe\n  1) English\n  2) Deutsch\n العربية (3 \n  4) Español" +
                "\n  5) русский\n  6) 中国\n  7) Français\n  x) Kurs eklemeyi bitir");
        while(true){
            System.out.print(" > ");
            kursRaw = in.nextLine();
            if(kursRaw.equals("x") || kursRaw.equals("X")) {
                if(donguSayisi == 0){
                    System.out.println(" ! Ders eklemeden çıkış yapamazsınız!");
                    continue;
                } else {
                    System.out.println(" > Ders ekleme işlemi bitti.\n");
                    break;
                }
            } else {
                kurss = Integer.parseInt(kursRaw);
                if ( kurss < 0 || 7 < kurss ) {
                    System.out.println(" ! Böyle bir kurs yok, tekrar deneyiniz!");
                    continue;
                }
            }

            Course kurs = Course.findCourse();
            kurs.addStudent(newStudent.getId());
            kurs.setLanguage(kurss);
            courses.add(kurs);
            System.out.println(" > " + kursTable[kurss] + " kursu eklendi!");
            money = money + 1000;
            donguSayisi++;
        }
        newStudent.setDebt(money);
        System.out.println(" > Toplam Borcunuz : " + money );
        while(true) {
            System.out.print(" > Ödeme yöntemi seçiniz: " + "\n  1) Peşin \n  2) Taksit \n > ");
            int odemeYontemi = Integer.parseInt(in.nextLine());
            if (odemeYontemi == 2) {
                System.out.print(" !> Kaç taksit? ");
                newStudent.setInstallment(in.nextInt());
                break;
            } else if (odemeYontemi == 1) {
                System.out.println(" !> Ödemeyi müşteriden alınız.");
                while(true) {
                    System.out.println(" !> Ödemeyi aldığınızı onaylıyor musunuz (Evet) ");
                    if ( in.nextLine().equals("Evet")) {
                        System.out.println(" !> Ödeme tamamlandı ");
                        break;
                    }

                }
                newStudent.setInstallment(0);
                break;
            } else {
                System.out.println(" ! Hatali giris!");
            }
        }
        newStudent.setCourses(courses);


        // Database kayıt
        DbConnection db = new DbConnection();
        db.initialize();

        try {
            db.insertStudent(newStudent);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        db.close_connection();

        System.out.println(" > " + newStudent.getName() + " " + newStudent.getSurname() + " başarıyla kaydedildi!");
        System.out.println(" > Devam etmek için Enter'a basınız");
        try{System.in.read();}
        catch(Exception e){}
        //in.close();

    }

    public static void sil() {

        Scanner in = new Scanner(System.in);
        System.out.print(" > Kaydını silmek istediğiniz öğrencinin ID'sini giriniz: ");
        int id = in.nextInt();

        DbConnection db = new DbConnection();
        db.initialize();
        db.deleteStudent(id);
        db.close_connection();

        System.out.println(" > " + id + " id'li departman sistemden başarıyla silindi! ");
        System.out.println(" > Devam etmek için Enter'a basınız");
        try{System.in.read();}
        catch(Exception e){}
        //in.close();
    }
}
