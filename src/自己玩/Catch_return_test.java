package 自己玩;

import 自己玩.数据结构.SetTest;

import javax.annotation.Resource;

public class Catch_return_test {

    @Resource
    private SetTest setTest;

    public static String test(){
        String s = "";
        try {
            s += "return try";
            int a = 1;
            int b = 1 / 0;
            return s;
        }catch (Exception e){
            s += "----catch添加";
            System.out.println("catch执行");
            return s;
        }finally {
            s += "----finally添加";
            System.out.println("finally执行");
            // return s;  // 最后会返回finally中的返回值
        }
        // return "正常执行";
    }

    public static void main(String[] args) {
        System.out.println(test());
    }

}
