package 算法练习.挑战赛初赛java赛题.other;

import java.util.Scanner;

public class LetterEliminate {
//    字母连连看，输入一个全为小写字母的字符串，如果字符串中有两个相同的字母就消除，不断重复操作，直到该字符串不能消除为止，
//    如果完全消除就输出YES，如果未完全消除就输出余下的字符

    // 返回a数组的距离i的下一个为0的值
    public int getIndex(int arr[],int i){
        int t = i;
        for (;t<arr.length;t++){
            if (arr[t]==0){
                return t;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int i = 0;
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();   // 输入全是小写字母的字符串
        int[] a = new int[s.length()];   // 创建一个整型字符串，与字符串型字符串一一对应

        for (i = 0; i < s.length()-1; i++){
            if (a[i]==0){
                if (s.charAt(i)==s.charAt(new LetterEliminate().getIndex(a,i+1))){
                    // 将其消除
                    a[i] = 1;
                    a[new LetterEliminate().getIndex(a,i+1)] = 1;
                    i = -1;
                }
            }
        }
        // 判断是否消除完毕
        for (i = 0; i < a.length; i++) {
            if (a[i]==0){
                // 如果还有剩下的字母没有消除完毕，则输出剩下的字母
                for(int j =0;j<s.length();j++){
                    if (a[j]==0){
                        System.out.print(s.charAt(j));
                    }
                }
                break;
            }
        }
        if (i==a.length){
            System.out.println("YES");
        }

    }
}
