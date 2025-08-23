package 算法练习.力扣练习.二分查找;

public class 搜索二维矩阵 {

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

}
