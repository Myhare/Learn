package 算法练习.力扣练习.其他练习;

// 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回该列名称对应的列序号。
//         输入: columnTitle = "A"
//         输出: 1
//         输入: columnTitle = "AB"
//         输出: 28
//         输入: columnTitle = "ZY"
//         输出: 701
public class 表列序号Excel {

    public static int titleToNumber(String columnTitle) {
        int number = 0;
        int multiple = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            int k = columnTitle.charAt(i) - 'A' + 1;
            number += k * multiple;
            multiple *= 26;
        }
        return number;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("AB"));
    }

}
