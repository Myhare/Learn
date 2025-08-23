package 自己玩;

public class StringTest {

    //不可变的String
    public static String appendStr(String s){
        s+="bbb";
        return s;
    }

    //可变的StringBuilder
    public static StringBuilder appendSb(StringBuilder sb){
        return sb.append("bbb");
    }

    public static void main(String[] args){
        //String做参数
        String s=new String("aaa");
        String ns=StringTest.appendStr(s);
        System.out.println("String aaa >>> "+s.toString());
        System.out.println("String aaa >>> "+ns.toString());

        //StringBuilder做参数
        StringBuilder sb=new StringBuilder("aaa");
        StringBuilder nsb=StringTest.appendSb(sb);
        System.out.println("StringBuilder aaa >>> "+sb.toString());
        System.out.println("StringBuilder aaa >>> "+nsb.toString());
    }

}
