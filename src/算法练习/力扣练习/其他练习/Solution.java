package 算法练习.力扣练习.其他练习;

public class Solution {
    public static double angleClock(int hour, int minutes) {
        double h,m;
        double hourF = (double)hour;
        double minutesF = (double)minutes;

        h = (hourF%12)*30+minutesF*0.5;
        m = (minutesF%60)*6;

        if(h>m){
            return h-m;
        }else{
            return m-h;
        }
    }

    public static void main(String[] args) {
        double v = angleClock(1, 57);
        System.out.println(v);
    }
}

//class Solution {
//    public int minJumps(int[] arr) {
//
//        int k = 0;
//        int sum = 0;
//        // 如果数组长度为一，直接返回0
//        if(arr.length==1){
//            return 0;
//        }
//
//        for(int i=arr.length-1;i>0;i--){
//            if(arr[i]==arr[k]){
//                k = i;
//                sum+=1;
//            }
//        }
//        return sum + arr.length-k-1;
//
//
//    }
//}
