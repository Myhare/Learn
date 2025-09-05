package 算法练习.力扣练习.剑指Offer;

import java.util.ArrayList;
import java.util.List;

public class 全排列 {

    public static void main(String[] args) {
        int[] ints = {1, 2, 3};
        List<List<Integer>> permute = permute(ints);
        for (List<Integer> integers : permute) {
            System.out.println(integers);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        boolean[] booleans = new boolean[nums.length];
        dfs(lists, nums, booleans, new ArrayList<>());
        return lists;
    }

    private static void dfs(List<List<Integer>> lists, int[] nums, boolean[] booleans,List<Integer> list) {
        if (list.size() >= nums.length){
            lists.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!booleans[i]){
                list.add(nums[i]);
                booleans[i] = true;
                dfs(lists, nums, booleans, list);
                booleans[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

}
