package 算法练习.力扣练习.困难难度;

import java.util.HashMap;
import java.util.Map;

public class 青蛙过河 {

    public boolean canCross(int[] stones) {
        // key:value 位置，是否存在石子
        Map<Integer, Boolean> map = new HashMap<>();
        for (int stoneIndex : stones) {
            map.put(stoneIndex, true);
        }
        return backTracking(stones, 1, 1, map);
    }

    // 青蛙第一步只能跳一步单位

    public boolean backTracking(int[] stones, int index, int step, Map<Integer, Boolean> map){
        // 如果当前下标到达了最远的距离，相当于已经跳到最后了
        if (index >= stones.length){
            return index == stones.length;
        }
        // 可以跳跃step-1，step，step+1三种情况
        // 判断跳step-1的情况下能不能跳道石子上
        boolean can1 = false;
        if (map.get(index + step - 1) != null) {
            can1 = backTracking(stones, index + step - 1, step - 1, map);
        }

        boolean can2 = false;
        if (map.get(index + step) != null) {
            can2 = backTracking(stones, index + step, step, map);
        }

        boolean can3 = false;
        if (map.get(index + step + 1) != null) {
            can3 = backTracking(stones, index + step + 1, step + 1, map);
        }

        return can1 || can2 || can3;
    }

    public static void main(String[] args) {
        int[] stones = {0,1,3,5,6,8,12,17};
        int[] stones2 = {0,1,2,3,4,8,9,11};
        System.out.println(new 青蛙过河().canCross(stones));
        // System.out.println(new 青蛙过河().canCross(stones2));
    }

}
