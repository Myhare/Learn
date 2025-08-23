package 算法练习.蓝桥杯练习.真题;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 括号问题 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int len = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入括号串:");
        String s = scanner.nextLine();

        String[] left = {"(","[","{"};
        String[] right = {")","]","}"};

        // 创建文件出入流和文件输出流
        FileInputStream in = null;
        FileOutputStream out = null;
        byte[] buffers = new byte[1024];

        File file = new File("算法.txt");
        try {
            // 如果文件存在，清除文件并重新创建
            if (file.exists()){
                file.delete();
                file.createNewFile();
            }
            out = new FileOutputStream(file,true);

            for (int i = 0; i < s.length(); i++) {
                if (Arrays.binarySearch(left,s.charAt(i)+"") >= 0){   // 说明查询到的是左括号
                    list.add(s.charAt(i)+"");
                    len++;
                } else if (Arrays.binarySearch(right,s.charAt(i)+"") >= 0){   // 说明查询到的是右括号
                    if (list.size()==0){   // 说明左边已经没有左括号了
                        System.out.println("false");
                        buffers = "false".getBytes(StandardCharsets.UTF_8);
                        out.write(buffers,0,buffers.length);
                        return;
                    }
                    // 先判定列表最后一个元素是不是和这个右括号相互匹配
                    if (!((s.charAt(i)+"").equals(")") && list.get(len-1).equals("(")
                            || (s.charAt(i)+"").equals("]") && list.get(len-1).equals("[")
                            || (s.charAt(i)+"").equals("}") && list.get(len-1).equals("{"))){   // 如果不匹配括号
                        System.out.println("false");

                        buffers = "false".getBytes(StandardCharsets.UTF_8);
                        out.write(buffers,0,buffers.length);

                        return;
                    }else {    // 说明右括号和左括号相互匹配了，删除列表中最后一个左括号
                        list.remove(len-1);
                        len--;
                    }
                }

            }
            if (list.size()==0){
                System.out.println("true");
                buffers = "true".getBytes(StandardCharsets.UTF_8);
                out.write(buffers,0,buffers.length);
            }else {
                System.out.println("false");
                buffers = "false".getBytes(StandardCharsets.UTF_8);
                out.write(buffers,0,buffers.length);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
