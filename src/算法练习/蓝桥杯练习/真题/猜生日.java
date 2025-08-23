package 算法练习.蓝桥杯练习.真题;

public class 猜生日 {
    /*
        今年的植树节（2012年3月12日），小明和他的叔叔还有小伙伴们一起去植树。
        休息的时候，小明的同学问他叔叔多大年纪，他叔叔说：“我说个题目，看你们谁先猜出来！”
                “把我出生的年月日连起来拼成一个8位数（月、日不足两位前补0）正好可以被今天的年、月、日整除！”
        他想了想，又补充到：“再给个提示，我是6月出生的。”
        根据这些信息，请你帮小明算一下，他叔叔的出生年月日。
        答案写在“算法.txt”中，不要写在这里！
        格式是年月日连成的8位数。
        例如，如果是1948年6月12日，就写：19480612
     */

    // 判断一个年份是不是闰年
    public static boolean isLeapYear(String yearS){

        int year = Integer.parseInt(yearS);
        if (year%4==0 && year%100!=0 && year%400==0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        for (int i = 20200312; ; i--){

            String s = Integer.toString(i);
            String[] date = new String[3];
            date[0] = s.substring(0,4);   // 年
            date[1] = s.substring(4,6);   // 月
            date[2] = s.substring(6,8);   // 日
            if (!(s.charAt(4)=='0' && s.charAt(5)=='6')){   // 如果不是六月份出生的，直接进入下一个循环
                continue;
            }

            // 如果月份是2月份，最大只有28天或者29天，如果超过28天跳出这个循环
            if (date[1].equals("02")){
                int day = Integer.parseInt(date[2]);
                // 如果是闰年，最大有29天
                if (isLeapYear(date[0])){   // 如果是闰年，最大有29天
                    if (Integer.parseInt(date[2])>29){
                        continue;
                    }else {   // 如果不是闰年，最大有28天
                        if (Integer.parseInt(date[2])>28){
                            continue;
                        }
                    }
                }
            }else if (date[1].equals("01") || date[1].equals("03") ||
                      date[1].equals("05") || date[1].equals("07")||
                      date[1].equals("08") || date[1].equals("10")||
                      date[1].equals("12")){        // 如果是1,3,5,7,8,10,12月份，最大有31天
                if (Integer.parseInt(date[2])>31){
                    continue;
                }
            }else {
                if (Integer.parseInt(date[2])>30){
                    continue;
                }
            }

            if (i % 2012 == 0 && i%12 == 0){
                System.out.println(i);
                break;
            }

        }

    }

}
