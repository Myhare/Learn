package 自己玩.多线程;

public class MyTest {



    public static void main(String[] args) {
        Test test = new Test();
        new Thread(()->{
            test.test();
        },"线程名字1").start();

        new Thread(()->{
            test.test();
        },"线程名字2").start();

        new Thread(()->{
            test.test();
        },"线程名字3").start();
    }
}

class Test{
    public static int t = 0;

    public synchronized  void test(){
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName()+"中的"+ t++ +"自增-后值是："+t);

        }
        System.out.println("当前线程名称："+Thread.currentThread().getName()+"执行完成");
    }
}

