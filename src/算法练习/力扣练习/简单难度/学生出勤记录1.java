package 算法练习.力扣练习.简单难度;

public class 学生出勤记录1 {


    /*
        给你一个字符串 s 表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
        'A'：Absent，缺勤
        'L'：Late，迟到
        'P'：Present，到场
        如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
        按 总出勤 计，学生缺勤（'A'）严格 少于两天。
        学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。
        如果学生可以获得出勤奖励，返回 true ；否则，返回 false 。
     */

    /*
        数组中 A出现的次数少于两次
              L不会连续出现三次
     */

    public static boolean checkRecord(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        boolean flag = true;
        int countA = 0;  // 记录A出现的次数
        int countL = 0;  // 记录L出现的次数
        int lastIndexL = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='A'){
                countA++;
            }
            if (chars[i] == 'L' && (lastIndexL == i - 1 || lastIndexL == 0)){
                lastIndexL = i;  // 记录此时的位置
                countL++;
            }else {  // 没有出现L，lastIndexL重置为0
                lastIndexL = 0;
                countL = 0;
            }
            if ( countA >= 2 || countL >= 3){
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(checkRecord("PPALLL"));
    }

}
