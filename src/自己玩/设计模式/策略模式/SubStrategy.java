package 自己玩.设计模式.策略模式;

public class SubStrategy implements Strategy{
    @Override
    public int print(int a, int b) {
        return a - b;
    }
}
