package 自己玩.字符串常量池;

public class StringTable_demo2 {

    public static void main(String[] args) {
        String s = new String("a") + new String("b"); // 这里的s指向堆中，没有放入字符串常量池
        System.out.println(s == "ab");  // false
        String s2 = s.intern(); // 尝试将ab放入字符串常量池
        System.out.println(s2 == "ab");  // true  因为s2指向的是常量池中的对象
        System.out.println(s == "ab");  // 一个指向堆内存，一个指向字符串常量池
        System.out.println(s == s2);  // 一个指向的是堆中的内存，一个指向的是字符串常量池
    }

}
