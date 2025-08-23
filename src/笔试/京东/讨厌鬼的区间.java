package 笔试.京东;

import java.util.Scanner;

public class 讨厌鬼的区间 {

    // 三个区间找重合的最大值

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l1 = in.nextInt();
        int r1 = in.nextInt();
        int l2 = in.nextInt();
        int r2 = in.nextInt();
        int l3 = in.nextInt();
        int r3 = in.nextInt();
        // 找出[l1,r1],[l2,r2],[l3,r3]区间重合的最大值
        int temp1 = 0;
        // 如果第一个和第二个有交集
        if (r1 >= l2 && r1 <= r2){
            temp1 = r1;
        }
        if (l1 >= l2 && l1 <= r2){
            temp1 = Math.max(temp1, r2);
        }

        int temp2 = 0;
        if (r2 >= l3 && r2 <= r3){
            temp2 = r2;
        }
        if ( l2 >= l3 && l2 <= r3 ){
            temp2 = Math.max(temp2, r3);
        }

        int temp3 = 0;
        if (r1 >= l3 && r1 <= r3){
            temp3 = r1;
        }
        if (l1 >= l3 && l1 <= r3){
            temp3 = Math.max(temp3, r3);
        }
        int max = temp1;
        max = Math.max(max, temp2);
        max = Math.max(max, temp3);
        System.out.println(2 * max);
    }

}
