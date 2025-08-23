package 笔试.微众;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class 酷 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }

        Arrays.sort(nums);

        int sum = 0;

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])){
                // 当前数字已经存在了，将这个数慢慢相加
                int t = nums[i];
                while (true){
                    t++;
                    if (!set.contains(t)){
                        sum += t - nums[i];
                        set.add(t);
                        break;
                    }
                }
            }else {
                set.add(nums[i]);
            }
        }

        System.out.println(sum);
    }

}
