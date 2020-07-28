import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Student student1 = new Student();
//        Course course1 = new Course();
//        Classroom classroom1 = new Classroom();
//        Instructor instructor1 = new Instructor();
//        Department department1 = new Department();
//        course1.setLevel(3);
//        ArrayList<Course> courses1 = new ArrayList<Course>();
//        courses1.add(course1);
//        student1.setCourses(courses1);
//        Date date = new Date();
//        System.out.println(date.toString());
//        System.out.println(student1.getCourses().get(0).getLevel().toString());
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Modül seçiniz.\n" +
//                "1.Ogrenci Ekle\n" +
//                "2.Departman Ekle\n" +
//                "");
//        int modulNum = scanner.nextInt();
//        if (modulNum == 1){
//        }

        Scanner in = new Scanner(System.in);
        System.out.println("\n    > Bir Dil Bir İnsan Dil Kursu Sistemine Hoşgeldiniz < \n");
        while(true) {
            System.out.println("    > Lütfen yapmak istediğiniz işlemi seçiniz ");
            System.out.println("    1) Öğrenci kaydetmek ");
            System.out.println("    2) Departman açmak ");
            System.out.println("    3) Öğrenci kaydı silme ");
            System.out.println("    4) Departman silme ");
            System.out.print  ("    >  ");
            String selection = in.nextLine();
            switch(selection) {
                case "1":
                    Student.ekle();
                    break;
                case "2":
                    Department.ekle();
                    break;
                case "3":
                    Student.sil();
                    break;
                case "4":
                    Department.sil();
                    break;
                default:
                    System.out.println("   > Geçersiz seçim, lütfen tekrar seçiniz: ");
                    continue;
            }

        }
        //in.close();

    }
}
