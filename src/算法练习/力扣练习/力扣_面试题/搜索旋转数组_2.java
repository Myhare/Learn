package 算法练习.力扣练习.力扣_面试题;

public class 搜索旋转数组_2 {

    public static void main(String[] args) {
        int[] arr = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        int[] arr2 = {5,5,5,1,2,3,4,5};
        int[] arr3 = {2, 1, 2, 2, 2};
        System.out.println(search(arr2, 5));
    }

    // 1. 判断左侧还是右侧有序，至少有有一侧是有序的
    // 2. 判断target在左侧还是右侧
    public static int search(int[] arr, int target) {
        // 特殊情况处理，防止刚好旋转使得目标值左右分割
        if(arr[0] == target){
            return 0;
        }
        int left = 0, right = arr.length - 1;

        while (left <= right){
            int mid = (left + right) / 2;
            // 判断左侧有序还是右侧有序
            if (arr[mid] == target){
                int tempIndex = mid;
                while (tempIndex > 0){
                    if (arr[tempIndex] != arr[tempIndex - 1]){
                        return tempIndex;
                    }
                    tempIndex--;
                }
                return 0;
            }
            // 左侧有序
            if (arr[mid] > arr[left]){
                // target在左侧还是右侧
                if (target >= arr[left] && target <= arr[mid]){
                    // 在mid左侧
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else if (arr[mid] < arr[left]){
                // 右侧有序
                if (target >= arr[mid] && target <= arr[right]){
                    // target在有序的那一侧
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }else {
                left++;
            }
        }
        return -1;
    }

}
