package 自己玩;

public class TestStatic {

    public static TestStatic t1 = new TestStatic();
    public static TestStatic t2 = new TestStatic();

    // 编译器会把构造代码块插入到每个构造函数的最前端
    // 每次创建对象的时候调用
    {
        System.out.println("构造块");
    }

    // JVM创建静态变量是从上往下创建的，如果下面静态块放到静态变量上面，就会先输出静态块
    // 静态块，JVM加载类的时候执行，仅执行一次
    static {
        System.out.println("静态块");
    }

    // 下面代码的运行结果
    public static void main(String[] args) {
        // 手动创建一个对象，又会输出一个构造块
        TestStatic testStatic = new TestStatic();
    }

}
