package 笔试.微众;

import java.util.HashSet;
import java.util.Scanner;

public class 切糖果 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] nums = new int[n + 1];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }

        HashSet<Integer> set = new HashSet<>();

        for (int i = 1; i < nums.length; i++) {
            if (set.contains(nums[i])){
                System.out.println(i - 1);
                break;
            }
            set.add(nums[i]);
        }

    }

}
