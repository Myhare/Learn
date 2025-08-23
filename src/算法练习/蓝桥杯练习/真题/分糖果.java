package 算法练习.蓝桥杯练习.真题;

import java.util.Scanner;

public class 分糖果 {
    /*
        有n个小朋友围坐成一圈。老师给每个小朋友随机发偶数个糖果，然后进行下面的游戏：
        每个小朋友都把自己的糖果分一半给左手边的孩子。
        一轮分糖后，拥有奇数颗糖的孩子由老师补给1个糖果，从而变成偶数。
        反复进行这个游戏，直到所有小朋友的糖果数都相同为止。
        你的任务是预测在已知的初始糖果情形下，老师一共需要补发多少个糖果。
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean flag = true;
        int count = 0;   // 老师要给的糖果

        int n = scanner.nextInt();  // 总人数

        if (n==1){
            System.out.println(0);;
        }

        int[] nums = new int[n];   // 代表n个小孩每个人的糖果数
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }
        int t = nums[0]/2;
        // 循环遍历，每个人都将自己的糖果分一半给左边的人
        while (flag){
            // 循环给糖果
            for (int i = 0; i < nums.length; i++) {
                if (i==n-1){
                    // 分一半的糖果给左侧的人
                    nums[i] = nums[i]/2 + t;
                }else {
                    nums[i] = nums[i]/2 + nums[i+1]/2;
                }
            }

            for (int i = 0; i < nums.length; i++) {
                if (nums[i]%2 != 0){
                    nums[i]++;  // 老师给一个糖果
                    count++;
                }
            }

            // 判断所有用户的糖果是否相同
            int j = 0;
            for (; j < nums.length-1; j++) {
                if (nums[j]!=nums[j+1]){
                    flag = true;
                    break;
                }
            }
            if (j == n - 1){
                flag = false;  // 跳出循环
            }
        }
        System.out.println(count);
        scanner.close();
    }

}
