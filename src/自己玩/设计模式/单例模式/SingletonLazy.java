package 自己玩.设计模式.单例模式;

/**
 * 懒汉式单例模式
 */
public class SingletonLazy {

    /*
     *  懒汉式单例模式不是线程安全的
     *  如果有多个线程同时获取对象，会同时认为单例为null，从而创建多个对象返回
     */

    private static SingletonLazy singletonLazy = null;

    public SingletonLazy() {

    }

    public static SingletonLazy getSingletonLazy(){
        if (singletonLazy == null){
            // 加锁放在判断之后，在创建对象之后就不会加锁了
            synchronized (SingletonLazy.class){
                if (singletonLazy == null){
                    singletonLazy = new SingletonLazy();
                }
            }
        }
        return singletonLazy;
    }

}
