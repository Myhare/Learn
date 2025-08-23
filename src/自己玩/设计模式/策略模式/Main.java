package 自己玩.设计模式.策略模式;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Content().invokeSum("addStrategy", 1, 2));
    }

}
