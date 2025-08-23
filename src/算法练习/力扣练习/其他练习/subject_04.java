package 算法练习.力扣练习.其他练习;



import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class subject_04 {
    //「HTML 实体解析器」 是一种特殊的解析器，它将 HTML 代码作为输入，并用字符本身替换掉所有这些特殊的字符实体。
    // @quot ---> "
    // @apos -->  '
    // @amp  -->  &
    // @gt   -->  >
    // @lt   -->  <
    // @frasl-->  /

    // 输入原本的字符串，返回解析后的字符串
    public String getString(String s){
        // 创建一个HashMap对象，储存要转义的字符
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("&quot;","\"");
        hashMap.put("&apos;","'");
        hashMap.put("&amp;","&");
        hashMap.put("&gt;",">");
        hashMap.put("&lt;","<");
        hashMap.put("&frasl;","/");

        String s2 = "";
        String t = "";
        boolean flag = false;

        //     &amp; is an HTML entity but &ambassador; is not

        for (int i = 0; i<s.length(); i++){
            if (s.charAt(i)=='&'){   // 如果字符串中有@符号，则判断是不是特殊符号
                t = t + s.charAt(i);
                for (int j = i+1;s.charAt(j)!='&' && s.charAt(j)!=' ';j++){
                    if (s.charAt(j) == ';'){
                        t = t + s.charAt(j);
                        break;
                    }
                    t = t + s.charAt(j);
                }
                // 遍历字符池查询临时字符串t是不是转义字符
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    if (entry.getKey().equals(t)){   // 如果是转义字符,将字符池对应的value对象传入到s2中
                        s2 = s2 + entry.getValue();
                        flag = true;
                    }
                }
            }

            // 跳过转义后的字符串
            if (flag){
                i = i + t.length();
                flag = false;
            }
            t = "";
            if (i<s.length()){
                s2 = s2 + s.charAt(i);
            }
        }
        return s2;
    }

    @Test
    public void test(){
        String string = getString("&amp;&amp;");
        System.out.println(string);
    }

}
