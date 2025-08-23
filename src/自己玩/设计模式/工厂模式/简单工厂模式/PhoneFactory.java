package 自己玩.设计模式.工厂模式.简单工厂模式;

/**
 * 手机工厂
 */
public class PhoneFactory {

    public static Phone getPhone(String phoneName){
        if ("小米".equals(phoneName)){
            return new XiaomiPhone();
        }else if ("苹果".equals(phoneName)){
            return new IPhonePhone();
        }
        return null;
    }


}
