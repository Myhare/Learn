package 自己玩.设计模式.工厂模式.简单工厂模式;

// 模拟消费者
public class Customer {

    public static void main(String[] args) {
        Phone xiaomi = PhoneFactory.getPhone("小米");
        System.out.println(xiaomi.getPhone());
    }

}
