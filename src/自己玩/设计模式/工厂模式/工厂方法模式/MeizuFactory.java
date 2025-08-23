package 自己玩.设计模式.工厂模式.工厂方法模式;

public class MeizuFactory implements PhoneFactory{
    @Override
    public Phone getPhone() {
        String a = "";
        return new Meizu();
    }
}
