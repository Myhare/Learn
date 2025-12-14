package 算法练习.力扣练习.二分查找;

public class 搜索二维矩阵 {

    // 可以优化，只使用两次二分查找，第一次找到比target小的最大的数，第二次对这一行做二分查找
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 0; i < n; i++){

            int left = 0;
            int right = m - 1;

            while(left <= right){
                int mid = (left + right) / 2;

                if(matrix[i][mid] > target){
                    right = mid - 1;
                }else if(matrix[i][mid] < target){
                    left = mid + 1;
                }else{
                    return true;
                }
            }

        }
        return false;
    }

    // 优化方法
    public static boolean searchMatrix2(int[][] matrix, int target) {
        int y = binaryY(matrix, target);
        // 二分查找这一行有没有这个值
        int left = 0, right = matrix[y].length - 1;

        // 左闭右闭
        while (left <= right){
            int mid = left + (right - left)/2;
            int tempValue = matrix[y][mid];
            if (tempValue > target){
                right = mid - 1;
            }else if (tempValue < target){
                left = mid + 1;
            }else {
                return true;
            }
        }
        return false;
    }

    // 找到第一个比target小的数
    public static int binaryY(int[][] matrix, int target){
        int high = 0, low = matrix.length;

        // 左闭右开
        // 下面方法如果没有匹配的值，会返回第一个比target大的值的下标
        while (high < low){
            int mid = high + (low - high) / 2;
            int tempValue = matrix[mid][0];
            if (tempValue >= target){
                low = mid;
            }else {
                high = mid + 1;
            }
        }

        return high > 0 ? high - 1 : high;
        // 正常使用二分，直接返回，会得到下标值，或者大于target的第一个值的下标
//        return high;
    }

    // 最后优化，一次二分查找直接解决
    public static boolean searchMatrix3(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;

        // 左闭右闭
        while (left <= right){
            int mid = left + (right - left)/2;
            int tempValue = matrix[mid / n][mid % n];
            if (tempValue > target){
                right = mid - 1;
            }else if (tempValue < target){
                left = mid + 1;
            }else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int[][] arr2 = {{1},{3}};
        System.out.println(searchMatrix3(arr2,3));
    }



}
