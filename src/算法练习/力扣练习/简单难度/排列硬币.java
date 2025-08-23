package 算法练习.力扣练习.简单难度;

public class 排列硬币 {

    // 越界
    public int arrangeCoins(int n) {
        int sum = 0;
        for(int i = 1; sum < n ; i++){
            sum = sum + i;
            if(sum == n){
                return i;
            }
            if (sum > n){
                return i-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new 排列硬币().arrangeCoins(5));
    }

}
