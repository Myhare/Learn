package 算法练习.蓝桥杯练习.蓝桥云课;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 杨辉三角形 {

    // 运行超时
    public void test1(){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1));
        list.add(Arrays.asList(1,1));
        int count = 0;
        for(int i = 2; ; i++){
            for(int j = 0; j < i; j++){
                count++;
                if(j == 0){
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(1);
                    list.add(tempList);
                    continue;
                }
                if(j == i - 1){
                    list.get(i).add(1);
                }
                // 到这里说明至少是中间的位置
                int t = list.get(i-1).get(j-1) + list.get(i-1).get(j);
                list.get(i).add(t);
                if(t == n){
                    System.out.println(count+1);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        if (n == 1){
            System.out.println(1);
            return;
        }
        long[][] arr = new long[n][];
        for (int i = 0; i < n; i++) {
            arr[i] = new long[i+1];
        }
        arr[0][0] = 1;
        arr[1][0] = 1;
        arr[1][1] = 1;
        int count = 3;
        for (int i = 2; i <= n; i++){
            for(int j = 0; j <= i; j++){
                count++;
                // 边缘为1
                if (j == 0 || j == i){
                    arr[i][j] = 1;
                    continue;
                }
                arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                if (arr[i][j] == n){
                    System.out.println(count);
                    return;
                }
            }
        }
    }

}
