package 算法练习.力扣练习.回溯;

import java.util.ArrayList;
import java.util.List;

public class 连续差相同的数字 {

    // 满座n位数字并且每一位差值为k的所有数字

    int k = 0;

    public int[] numsSameConsecDiff(int n, int _k) {
        k = _k;
        List<Integer> list = new ArrayList<>();
        backTracking(1,n,list,"");
        // System.out.println(list);
        int[] reArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            reArr[i] = list.get(i);
        }
        return reArr;
    }

    public void backTracking(int start,int n,List<Integer> list,String path){
        // 终止条件
        if (start > n && path.length() == n){
            list.add(Integer.parseInt(path));
            return;
        }

        // 当前第i个位置
        for(int i = start; i <= n; i++){

            for (int j = 0; j <= 9; j++) {
                if (i == 1 && j == 0){
                    // 第一个位置不能是0
                    continue;
                }
                // 判断当前位置符不符合要求
                if (path.length() == 0){
                    // 第一个位置，直接回溯
                    path = path + j;
                    backTracking(i+1,n,list,path);
                    path = path.substring(0,path.length()-1);
                }else {
                    // 不是第一个位置，需要判断是否满足条件
                    int a = path.charAt(path.length() - 1) - '0';
                    if (Math.abs(j - a) == k){
                        path = path + j;
                        backTracking(i+1,n,list,path);
                        path = path.substring(0,path.length()-1);
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        // System.out.println('1' - '0');
        int[] ints = new 连续差相同的数字().numsSameConsecDiff(2, 1);
        for (int a : ints) {
            System.out.println(a);
        }
    }

}
