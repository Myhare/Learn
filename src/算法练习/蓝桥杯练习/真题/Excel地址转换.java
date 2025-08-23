package 算法练习.蓝桥杯练习.真题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Excel地址转换 {

//    Excel是最常用的办公软件。每个单元格都有唯一的地址表示。 比如：第12行第4列表示为：“D12”，第5行第255列表示为“IU5”。
//    事实上，Excel提供了两种地址表示方法，还有一种表示法叫做RC格式地址。
//    第12行第4列表示为：“R12C4”，第5行第255列表示为“R5C255”。
//    你的任务是：编写程序，实现从RC地址格式到常规地址格式的转换。
//            【输入、输出格式要求】
//    用户先输入一个整数n(n<100)表示接下来有n行输入数据。
//    接着输入的n行数据是RC格式的Excel单元格地址表示法。
//    程序则输出n行数据，每行是转换后的常规地址表示法。
//    例如：用户输入：
//            2
//    R12C4
//            R5C255
//    则程序应该输出：
//    D12
//            IU5

    public static void main(String[] args) {
        // 定义一个字符串数组，用来表达二十六进制
        String[] index = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        List<String> list = new ArrayList<>();
        List<String> resultList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        // 循环输入n条数据到list中
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextLine());
        }
        scanner.close();
        //遍历list,将其进制转化为我们需要的输出格式
        for (String s : list) {
            // 将用户输入的s将其通过R和C分割
            s = s.replace("R", "");   // 先将输入的R去除
            String[] getS = s.split("C");
            String result = "";
            // 将分割后的第一个值直接传入t中
            result = getS[0];
            // 分割后将第二个值，转化为26进制
            for (int i = Integer.parseInt(getS[1]); i > 0; i = i/26) {
                int a = i % 26;
                result = index[a-1] + result;
            }
            // 将t传入结果集合中
            resultList.add(result);
        }

        for (String s : resultList) {
            System.out.println(s);
        }

    }


//        for (int i = 255; i>0;i = i/26){
//        int t = i %26;
//        s = index[t-1] + s;
//        }

}
