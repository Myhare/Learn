package 算法练习.力扣练习.简单难度;

import java.time.LocalDate;

public class 一年中的第几天 {


    // 输入2019-01-09格式的字符串，返回今天是今年的第几天
    public static int dayOfYear(String date) {
        String[] dateSplit = date.split("-");
        LocalDate localDate =
                LocalDate.of(Integer.parseInt(dateSplit[0]), Integer.parseInt(dateSplit[1]), Integer.parseInt(dateSplit[2]));
        // 获取今年的第几天时间
        return localDate.getDayOfYear();
    }

    public static void main(String[] args) {
        System.out.println(dayOfYear("2019-01-09"));
    }

}
