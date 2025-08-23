package 算法练习.力扣练习.二分查找;

public class 搜素二维矩阵2 {

    public boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = m - 1;

            while (left <= right){
                int mid = (left+right)/2;

                if (matrix[i][mid] == target){
                    return true;
                }else if (matrix[i][mid] > target){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }

        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(new 搜素二维矩阵2().searchMatrix(matrix, 5));
    }

}
