package Test;

public class Teacher extends Citizen{
    public String cardld;
    public String name;
    public String sex;
    public String teacherId;
    public String prof;

    public Teacher(String cardld, String name, String sex, String teacherId, String prof) {
        super(cardld, name, sex);
        this.teacherId = teacherId;
        this.prof = prof;
    }

    public void display(){
        System.out.println(teacherId);
        System.out.println(prof);
    }
}
