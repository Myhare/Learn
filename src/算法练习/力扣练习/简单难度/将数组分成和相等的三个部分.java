package 算法练习.力扣练习.简单难度;

public class 将数组分成和相等的三个部分 {

    public static boolean canThreePartsEqualSum(int[] arr) {
        int maxSum = 0;
        for (int i : arr) {
            maxSum += i;
        }
        if (maxSum % 3 != 0){
            return false;
        }
        int target = maxSum / 3;

        int nowValue = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            nowValue += arr[i];
            if (nowValue == target){
                nowValue = 0;
                count++;
            }
            if (count == 3){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
        int[] arr2 = {0,2,1,-6,6,7,9,-1,2,0,1};
        int[] arr3 = {3,3,6,5,-2,2,5,1,-9,4};
        System.out.println(canThreePartsEqualSum(arr));
        System.out.println(canThreePartsEqualSum(arr2));
        System.out.println(canThreePartsEqualSum(arr3));
    }

}
