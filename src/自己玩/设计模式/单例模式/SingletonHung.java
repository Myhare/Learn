package 自己玩.设计模式.单例模式;

/**
 * 单例设计模式(饿汉式)
 */
public class SingletonHung {

    /**
     * 饿汉式，在属性中直接new出来
     */
    private static SingletonHung singletonHung = new SingletonHung();

    SingletonHung(){

    }

    /**
     * 只能通过这种方法获取这个唯一的对象
     */
    public static SingletonHung getSingleton(){
        return singletonHung;
    }

}
