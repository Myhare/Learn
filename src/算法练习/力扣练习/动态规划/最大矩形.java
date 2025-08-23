package 算法练习.力扣练习.动态规划;

public class 最大矩形 {

    public int maximalRectangle(char[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        // 创建二维数组left表示left[i][j]位置的左边1的最大长度
        int[][] left = new int[n][m];
        // 初始化
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '0'){
                    left[i][j] = 0;
                }else {
                    // 当前位置是1
                    if (j == 0){
                        left[i][j] = 1;
                    }else {
                        left[i][j] = left[i][j-1] + 1;
                    }
                }
            }
        }

        // 从一个个节点往上遍历
        int maxVal = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 从当前节点一个一个网上面遍历，找出以当前下标为右下角的矩阵的面积的最大值
                int minWidth = m;
                for(int k = i; k >= 0; k--){
                    // 判断上面的值是不是0
                    if (left[k][j] == 0){
                        break;
                    }
                    int height = i - k + 1;
                    minWidth = Math.min(minWidth,left[k][j]);
                    maxVal = Math.max(maxVal, height * minWidth);
                }
            }
        }

        return maxVal;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        char[][] matrix2 = {{'1','1'}};
        System.out.println(new 最大矩形().maximalRectangle(matrix2));
    }

}
