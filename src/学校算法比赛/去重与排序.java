package 学校算法比赛;

import java.util.Arrays;
import java.util.Scanner;

public class 去重与排序 {

    // 给出N个1到1000之间的随机整数（N≤100），对于其中重复的数字，只保留一个，把其余相同的数去掉，之后再把剩下的数字

    public static void test(int n,int[] nums){
        if (nums.length==1){
            System.out.println(1);
            System.out.println(nums[0]);
            return;
        }
        int count = 0;
        int[] t = new int[nums.length];
        Arrays.sort(nums);  // 排序
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i+1]!=nums[i]){
                t[count] = nums[i];
                count++;
            }
        }
        if (nums[nums.length-1]!=t[count-1]){
            t[count] = nums[nums.length-1];
            count++;
        }
        System.out.println(count);
        for (int i = 0; i < count; i++) {
            System.out.print(t[i]+" ");
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        test(n,nums);
    }

}
