package Test.Mian;

import java.util.*;

public class 重组字符串 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[][] chars = new char[n][];
        for (int i = 0; i < n; i++) {
            chars[i] = scanner.next().toCharArray();
        }
        scanner.close();
        Set<String> reSet = new HashSet<>();
        dfs(0,"",chars,n,reSet);
        System.out.println(reSet.size());
    }

    public static void dfs(int index, String s, char[][] chars, int n, Set<String> reSet){
        if (index == n){
            reSet.add(s);
            return;
        }

        for (int i = 0; i < chars[index].length; i++) {
            // 判断是否存在
            if (s.contains(chars[index][i] + "")){
                continue;
            }
            dfs(index+1,s + chars[index][i],chars ,n,reSet);
        }

    }

}
