package 算法练习;

import java.util.HashMap;

public class 集合中的数字拼凑的不大于N的最大值 {

    public static int maxSize = 0;


    public static int getMaxSize(int[] arr, int k){
        dfs("", arr, k);
        return maxSize;
    }

    // 简单解决方法，可以有更高效的剪枝
    public static void dfs(String nowSize, int[] arr, int k){
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            // Java会有优化
            nowSize = nowSize + temp;
            // 判断当前temp和k的当前位数大小比较。如果更大，直接下一个循环
            if (Integer.parseInt(nowSize) >= k){
                // 剪枝
//                nowSize = nowSize.substring(0, nowSize.length() - 1);
                continue;
            }
            maxSize = Math.max(maxSize, Integer.parseInt(nowSize));
            dfs(nowSize, arr, k);
            nowSize = nowSize.substring(0, nowSize.length() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,4,9};
        System.out.println(getMaxSize(arr, 23121));
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,2);
    }

}