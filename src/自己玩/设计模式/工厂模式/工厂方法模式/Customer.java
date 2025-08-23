package 自己玩.设计模式.工厂模式.工厂方法模式;

/**
 * 消费者
 */
public class Customer {

    public static void main(String[] args) {
        new XiaomiFactory().getPhone().getBrand();
        new MeizuFactory().getPhone().getBrand();
    }

}
