package 算法练习.蓝桥杯练习.蓝桥云课;

import java.time.LocalDate;
import java.util.Scanner;

public class 回文日期 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // 输入日期
        String s = scanner.nextLine();
        scanner.close();

        // 获取年月日
        String year = s.substring(0, 4);
        String month = s.substring(4, 6);
        String day = s.substring(6, 8);
        // 生成LocalDate对象
        LocalDate localDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day)).plusDays(1);
        int count = 0;
        // 开始循环遍历下一天是不是回文数
        while (true){
            String tempYear = localDate.getYear() + "";
            String tempMonth = localDate.getMonth().getValue() + "";
            if (Integer.parseInt(tempMonth) < 10){
                tempMonth = "0" + tempMonth;
            }
            String  tempDay = localDate.getDayOfMonth() + "";
            if (Integer.parseInt(tempDay) < 10){
                tempDay = "0" + tempDay;
            }
            String nextDayS = tempYear + tempMonth + tempDay;
            if (count == 0){
                // 判断当前天数是不是回文串
                if (isHui(nextDayS)){
                    // 是回文串，直接输入
                    System.out.println(nextDayS);
                    count++;
                }
            }else if (count == 1){
                // 判断是不是ABAB类型
                if (isABAB(nextDayS)){
                    System.out.println(nextDayS);
                    return;
                }
            }
            // 下一天
            localDate = localDate.plusDays(1);
        }


    }

    // 判断是不是回文串
    public static boolean isHui(String s){
        int i = 0;
        int j = s.length()-1;
        while (i < j){
            char leftC = s.charAt(i);
            char rightC = s.charAt(j);
            if (leftC != rightC){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    // 判断是不是ABAB类型
    public static boolean isABAB(String s){
        char[] chars = s.toCharArray();
        char a = chars[0];
        char b = chars[1];
        // 这里可以直接保证是8位数 asassasa
        return a != b &&
                chars[0] == chars[2] && chars[2] == chars[5] && chars[5] == chars[7] &&
                chars[1] == chars[3] && chars[3] == chars[4] && chars[4] == chars[6];

    }

}
