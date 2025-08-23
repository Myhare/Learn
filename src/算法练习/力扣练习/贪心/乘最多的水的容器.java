package 算法练习.力扣练习.贪心;

public class 乘最多的水的容器 {

    // 暴力破解(超时)
    public static int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length-1; i++) {
            for (int j = i + 1; j < height.length; j++){
                int area = (j-i)*Math.min(height[j],height[i]);
                maxArea = Math.max(maxArea,area);
            }
        }
        return maxArea;
    }

    // 双指针方法
    public static int maxArea2(int[] height) {
        /*
            双指针方法
            当左右两个挡板的位置确定的时候，如果当前某一个挡板向内移动，
            如果长挡板向内移动，短长板长度不变，面积一定减小
            如果短挡板向内移动，短长板有可能增大，面积不一定减小
         */
        // 定义左右两个指针
        int i = 0;
        int j = height.length-1;
        int maxArea = (j-1)*Math.min(height[i],height[j]);
        while (i<j){
            // 如果左边板子是短板
            if (height[i]>=height[j]){
                // 将左边板子向右移动
                maxArea = Math.max(maxArea,(j-i)*Math.min(height[i],height[j--]));
            }else {
                maxArea = Math.max(maxArea,(j-i)*Math.min(height[i++],height[j]));
            }
        }
        return maxArea;
    }



    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height2 = {1,1};
        System.out.println(maxArea2(height));
    }

}
