public class MainSystem {
    public MainSystem(){
    }

    public Boolean payDept(Student student,Float amount){
        try{
            if (student.getDebt() < amount){
                return false;
            }
            student.setDebt(student.getDebt()-amount);
                return true;
        } catch (Exception e) {
            return false;
        }
    }


}
