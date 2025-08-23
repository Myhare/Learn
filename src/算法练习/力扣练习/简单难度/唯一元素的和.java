package 算法练习.力扣练习.简单难度;

import java.util.HashMap;
import java.util.Map;

public class 唯一元素的和 {

    /*
        给你一个整数数组 nums 。数组中唯一元素是那些只出现 恰好一次 的元素。
        请你返回 nums 中唯一元素的 和 。
     */
    // 创建一个map定义每一个元素出现的次数
    public static int sumOfUnique(int[] nums) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){  // 如果存在
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }
        for (Integer i : map.keySet()){
            if (map.get(i)==1){
                sum += i;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumOfUnique(new int[]{1,2,3,2}));
    }

}
