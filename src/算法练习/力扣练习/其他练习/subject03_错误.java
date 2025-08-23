package 算法练习.力扣练习.其他练习;

import org.junit.Test;

import java.util.Arrays;

public class subject03_错误 {
    //完成任务的最少工作时间段

    public int getTimePeriod(int[] arr,int sessionTime){

        // 1、先将数组由小到大排序
        // 2、将最大的一个数和sessionTime对比
        // 3、如果小于，就加上最小的一个数对比，如此循环

        int timePeriod = 0;
        int len = arr.length;
     //   int[] mark = new int[len];   // 创建一个标记数组，默认值为0
        Arrays.sort(arr);  // 将arr数组由小到大排序

        int maxTime = arr.length - 1;
        int sumTime = 0;     // 定义一个变量，用来记录时间之和，用来和sessionTime做对比
        for (int minTime = 0; minTime < arr.length; minTime++) {

            if (sumTime<sessionTime){
                sumTime = arr[maxTime] + sumTime;
       //         mark[maxTime] = 1;            // 说明这个时间段已经使用了
                if (sumTime+arr[minTime] <= sessionTime){   // 如果大的时间加上最小的时间还是小于需要的时间，继续循环
                    sumTime+=arr[minTime];
       //             mark[minTime] = 1;
                    maxTime--;
                    if (sumTime>=sessionTime){
                        minTime--;
                        timePeriod++;
                    }
                }else {
                    minTime--;        // 抵消循环后的minTime自增
                    maxTime--;
                    sumTime = 0;
                    timePeriod++;
                }
            }
        }
        return timePeriod;
    }

    @Test
    public void test(){
        int[] arr = {3,1,3,1,1};
        int timePeriod = getTimePeriod(arr,8);
        System.out.println(timePeriod);
    }

}
