package 算法练习.力扣练习.力扣_面试题;

public class 合并两个有序数组 {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,3,0,0,0};
        int[] arr2 = new int[]{2,5,6};
        int[] arr3 = new int[]{0};
        int[] arr4 = new int[]{1};
        // merge(arr1, 3, arr2, 3);
        merge(arr3, 0, arr4, 1);
        for (int i : arr3) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int s1Index = m - 1;
        int s2Index = n - 1;
        int len = nums1.length - 1;
        while (s1Index >= 0 && s2Index >= 0){
            if (nums1[s1Index] >= nums2[s2Index]){
                nums1[len] = nums1[s1Index];
                s1Index -= 1;
            }else {
                nums1[len] = nums2[s2Index];
                s2Index -= 1;
            }
            len--;
        }

        // 防止m == 0
        while (s2Index >= 0){
            nums1[len] = nums2[s2Index];
            len--;
            s2Index--;
        }
    }

}
