package 自己玩.设计模式.单例模式;

// 手动试一下单例
public class Main {

    public static volatile Main main;

    private Main(){}

    public static Main getMain(){
        if (main == null){
            synchronized (Main.class){
                if (main == null){
                    main = new Main();
                }
            }
        }
        return main;
    }

}
