package 自己玩.字符串常量池;

public class StringTable_demo {

    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        String s4 = new String("ab");
        String s5 = "a" + "b";
        String s6 = s1 + s2;
        System.out.println(s3 == s4); // false，因为s3在字符串常量池，s4在堆内存
        System.out.println(s4 == s5); // false，因为
        System.out.println(s3 == s6); // false，因为s1和s2是变量，需要在运行时才能确定，一个指向
        System.out.println(s3 == s5); // true，,结果在编译期间就确定为ab
    }

}
