package 自己玩;

// 实现Cloneable接口，否则使用clone会报错
public class A implements Cloneable{

    public String name;

    public int age;

    // 喜欢什么
    private String like = "ss";

    public A(String name, int age) {
        this.name = name;
        this.age = age;
        // System.out.println(like);  // 即使是子类构造犯法使用super调用附列，也可以使用private修饰的变量
    }

    @Override
    public String toString() {
        return "A{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        // A a = new A("小红", 11);
        // B b = new B("小白",22);
        // C c = new C("小黑",33);
        // System.out.println(a);
        // System.out.println(b);
        // System.out.println(c);
        // System.out.println("----------------");
        // b.ageAdd();
        // System.out.println(a);
        // System.out.println(b);
        // System.out.println(c);
        A a = new A("小红", 2);
        System.out.println(a.name + "----" + a.age);
        A a2;
        try {
            a2 = (A) a.clone();
            System.out.println("a2创建");
            System.out.println(a2.name + "----" + a2.age);
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        a2.name = "小兰";
        a2.age = 99;
        System.out.println("修改后");
        System.out.println(a.name + "----" + a.age);
        System.out.println(a2.name + "----" + a2.age);
    }
}

class B extends A {

    public B(String name, int age) {
        super(name, age);
    }

    public void ageAdd(){
        super.age += 100;
    }
}


class C extends A{

    public C(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
