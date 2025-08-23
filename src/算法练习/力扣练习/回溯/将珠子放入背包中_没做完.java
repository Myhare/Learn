package 算法练习.力扣练习.回溯;

public class 将珠子放入背包中_没做完 {

    long max = 0;
    long min = 0;

    public long putMarbles(int[] weights, int k) {
        // 表示每一个背包的容量
        long[] bucket = new long[k];

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;


        return 0;
    }

    /**
     * 回溯递归
     * @param weights  每个珠子的重量
     * @param start    当前开始下标
     * @param bucket   桶
     */
    public void buckTracking(int[] weights, int start, long[] bucket){
        if (start >= weights.length){
            // 维护最大和最小的值
            return;
        }

        for(int i = start; i < weights.length; i++){
            // 将start到i的珠子放入到当前的桶中
            long sum = 0;   // 当前区间珠子的总重量
            for(int k = start; k <= i; k++){
                sum += weights[k];
            }
            for (int j = 0; j < bucket.length; j++) {
                // 放到当前桶里面
                bucket[j] += sum;
                buckTracking(weights,i+1,bucket);
                bucket[j] -= sum;
            }
        }

    }

}
