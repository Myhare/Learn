package 算法练习.力扣练习.贪心;

public class 加油站 {

    /**
     * 加油站(超时)
     * @param gas       当前下标i加油站可以加的油的数量
     * @param cost      到下一个加油站需要消耗的油的数量
     * @return          结果
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int reIndex = -1;
        int fuelTank = 0;   // 当前油箱剩的油
        // int[] flag = new int[gas.length];       // flag判断当前位置
        int index = 0;  // 当前循环的下标
        for (int i = 0; i < gas.length; i++) {
            index = (i+1)%n;
            if (gas[i] - cost[i]>=0){
                // 计算油箱剩余油量
                fuelTank = fuelTank + gas[i] - cost[i];
                while (index != i){
                    fuelTank = fuelTank + gas[index] - cost[index]; // 计算油箱加油并且行驶后油量
                    if (fuelTank < 0){
                        break;
                    }
                    index = (index + 1) % n;
                }
                if (index == i){    // 说明当前下标可以走一圈
                    return index;
                }
                // 邮箱清空
                fuelTank = 0;
            }
        }
        return reIndex;
    }

    // 优化结果(报错)
    public static int canCompleteCircuit2(int[] gas, int[] cost) {
        /*
            遍历数组 i 从 0 开始累加 rest[i]，和记为 curSum；
            计算每个加油站的剩余量 curSum+=gas[i]−cost[i]；
            若 curSum 小于零，说明[0,i]区间都不能作为起始位置，起始位置从 i+1 算起，curSum 清零重新计算。
         */
        int n = gas.length;



        return -1;
    }



    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        int[] gas2 = {2,3,4};
        int[] cost2 = {3,4,3};
        int[] gas3 = {2};
        int[] cost3 = {2};
        System.out.println(canCompleteCircuit2(gas2,cost2));
    }

}
