package 算法练习.力扣练习.力扣_面试题;

public class 搜索旋转数组 {

    public static void main(String[] args) {
        int[] arr = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        int[] arr2 = {1,1,1,1,1,2,1,1,1};
        int[] arr3 = {2, 1, 2, 2, 2};
        System.out.println(search(arr3, 1));
    }

    // 1. 判断左侧还是右侧有序，至少有有一侧是有序的
    // 2. 判断target在左侧还是右侧
    public static int search(int[] arr, int target) {
        // 特殊情况处理
        if (arr[0] == target){
            return 0;
        }
        int left = 0, right = arr.length - 1;

        while (left <= right){
            int mid = (left + right) / 2;
            // 找到了target
            if (arr[mid] == target){
                // 获取最左测的下标
                int i = mid;
                while (i > 0){
                    if (arr[i - 1] != target){
                        return i;
                    }
                    i--;
                }
                return i;
            }
            // 左侧有序
            if (arr[mid] > arr[left]){
                // 判断target是否在左侧
                if (target >= arr[left] && target <= arr[mid]){
                    // 说明target在有序数组里面(左侧)
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else if (arr[mid] < arr[left]){
                // 右侧有序
                if (target >= arr[mid] && target <= arr[right]){
                    // 说明target在有序数组里面
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }else {
                // 重点， 如果arr[mid] == arr[left]，无法判断左边还是右边有序，采用保守的方式，left++
                left++;

            }
        }

        return -1;
    }

}
