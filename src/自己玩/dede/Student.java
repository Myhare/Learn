package 自己玩.dede;

public class Student extends Person{

    // 继承
    private int id;  // 学号

    public Student(){

    }

    public Student(int id) {
        this.id = id;
    }

    public Student(String name, String age, int id) {
        super(name, age);
        this.id = id;
    }

    public Student(String name, String age) {
        super(name, age);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void main(String[] args) {
        Student s = new Student();

        s.name = "dede";
        s.setAge("100");

        System.out.println(s.getAge());

    }

}
