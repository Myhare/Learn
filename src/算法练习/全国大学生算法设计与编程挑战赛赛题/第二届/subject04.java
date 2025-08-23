package 算法练习.全国大学生算法设计与编程挑战赛赛题.第二届;


public class subject04 {
    public static double getTime(int n,String s){
        double resultTime = 0;
        double addTime = 1;

        double count = 0;
        boolean flag = false;

        for (int i =0;i<n;i++){
            if (s.charAt(i)=='.'){  // 代表平地
                resultTime = resultTime + addTime;
                if (flag){
                    count = count+addTime;
                }
            }else if (s.charAt(i)=='w'){     // 代表水坑
                resultTime = resultTime + 2*addTime; // 速度减半,这里因为路程是固定的，所以时间会变成两倍，并且只有这个水坑速度减半
                if (flag){
                    count = count+addTime*2;
                }
            }else if (s.charAt(i)=='>'){   // 代表加速阵
                if (flag==true){   // 如果本身就在加速时状态，重置加速时间
                    resultTime = resultTime + addTime;
                    count=0;
                }else {           // 如果之前不在加速状态，速度减半并开始计时
                    addTime = addTime * 0.5;
                    resultTime = resultTime + addTime;
                    flag = true;      // 开始计数，速度翻倍五秒
                }
                if (flag){
                    count = count+addTime;
                }
            }else if (s.charAt(i)=='s'){   // 代表石块，碰到石块后在原地停留一秒
                resultTime = resultTime + 1;
                if (flag){
                    count = count+1;
                }
                if (count>=5){
                    flag = false;
                    addTime = 2 * addTime;   // 速度回到初始速度
                    count = 0;
                }
                resultTime = resultTime + addTime;
                if (flag){
                    count = count+addTime;
                }
                if (count>=5){
                    flag = false;
                    addTime = 2 * addTime;   // 速度回到初始速度
                    count = 0;
                }
            }else if (s.charAt(i)=='m'){    // 代表魔物，在这一个需要停留两秒
                resultTime = resultTime + 2;
                if (flag){
                    count = count+2;
                }
                if (count>=5){
                    flag = false;
                    addTime = 2 * addTime;   // 速度再一次减半
                    count = 0;
                }
                resultTime = resultTime + addTime;
                if (flag){
                    count = count+addTime;
                }
                if (count>=5){
                    flag = false;
                    addTime = 2 * addTime;   // 速度再一次减半
                    count = 0;
                }
            }
            if (count>=5){
                flag = false;
                addTime = 2 * addTime;   // 速度再一次减半
                count = 0;
            }
        }
        return resultTime;
    }

    public static void main(String[] args) {
        double time1 = getTime(10, ">.wwws..s.");
        System.out.println(time1);
        double time2 = getTime(10, ".>.wwws.s.");
        System.out.println(time2);
        double time3 = getTime(10, ">>>>>s.m.m");
        System.out.println(time3);
        double time4 = getTime(10, ">w.wss..s.");
        System.out.println(time4);
    }

}
