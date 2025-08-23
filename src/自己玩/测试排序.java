package 自己玩;

import java.util.Arrays;
import java.util.Scanner;

public class 测试排序 {

    public static void main(String[] args) {
        int[][] arr = {{7,1},{4,4},{7,0},{5,3},{6,1},{5,2}};
        System.out.println(Arrays.deepToString(arr));

        Arrays.sort(arr,(p1,p2)->{
            // 判断第一个元素是否相等
            if (p1[0] != p2[0]){
                return p2[0] - p1[0];
            }else {
                // 第一个元素相等，根据第二个元素进行排序
                return p1[1] - p2[1];
            }
        });
        System.out.println(Arrays.deepToString(arr));

        Arrays.sort(arr,(p1,p2) -> {
            if(p1[0] == p2[0]){
                return p1[1] - p2[1];
            }else{
                return p2[0] - p1[0];
            }
        });
        System.out.println(Arrays.deepToString(arr));

    }

}
