package 算法练习.力扣练习.回溯;

import java.util.HashSet;
import java.util.Set;

public class 活字印刷 {

    Set<String> set;

    public int numTilePossibilities(String tiles) {
        int n = tiles.length();
        boolean[] flags = new boolean[n];
        set = new HashSet<>();
        dfs(tiles, "", 0, flags);
        // System.out.println(set);
        return set.size();
    }

    public void dfs(String tiles, String path, int index,boolean[] flags){
        if(!"".equals(path)){
            set.add(path);
        }
        for(int i = 0; i < tiles.length(); i++){
            if(!flags[i]){
                // 标记当前位置
                flags[i] = true;
                path = path + tiles.charAt(i);
                dfs(tiles, path, i, flags);
                flags[i] = false;
                path = path.substring(0,path.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new 活字印刷().numTilePossibilities("AAABBC"));
    }

}
