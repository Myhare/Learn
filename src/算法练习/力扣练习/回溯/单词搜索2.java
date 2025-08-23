package 算法练习.力扣练习.回溯;

import java.util.*;

public class 单词搜索2 {

    public List<String> reList = new ArrayList<>();
    public int[][] move = {{0,1},{1,0},{0,-1},{-1,0}};
    public boolean isOk = false;

    public Set<String> set = new HashSet<>();

    // 暴力回溯----->超时
    public List<String> findWords(char[][] board, String[] words) {
        // 初始化数据
        reList = new ArrayList<>();
        isOk = false;
        int n = board.length;           // n行
        int m = board[0].length;        // m列
        boolean[][] flags = new boolean[n][m];

        Map<Character,Integer> boardMap = new HashMap<>();
        // 统计board中的英文数量
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (boardMap.containsKey(board[i][j])){
                    boardMap.put(board[i][j],boardMap.get(board[i][j])+1);
                }else {
                    boardMap.put(board[i][j],1);
                }
            }
        }

        for(String word : words){
            // 从每个位置开始深度优先遍历
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == word.charAt(0)){
                        backTracking(board,flags,word,n,m,i,j,0);
                        // 重置标记
                        flags = new boolean[n][m];
                        if (isOk){
                            break;
                        }
                    }
                }
                if (isOk){
                    isOk = false;
                    break;
                }
            }
        }

        return reList;
    }
    // x 行 y 列
    public void backTracking(char[][] board,boolean[][] flags,String word,int n, int m,int x,int y,int h){
        if(h >= word.length()){
            reList.add(word);
            this.isOk = true;
            return;
        }
        // 边界条件
        if(x < 0 || x >= n){
            return;
        }
        if(y < 0 || y >= m){
            return;
        }
        if(flags[x][y]){
            return;
        }
        // 对当前位置进行判断，是不是可以表示当前单词
        if(word.charAt(h) != board[x][y]){
            return;
        }
        // 能到达这里说明当前位置符合条件
        flags[x][y] = true;
        h++;
        // 深度优先遍历
        for(int i = 0; i < move.length; i++){
            if(isOk){
                return;
            }
            backTracking(board,flags,word,n,m,x+move[i][0],y+move[i][1],h);
        }
        // 回溯
        flags[x][y] = false;
        h--;
    }

    // 方法优化，使用前缀树进行回溯
    public List<String> findWords2(char[][] board, String[] words) {
        // 初始化数据
        set = new HashSet<>();
        Trie trie = new Trie();
        // 先将当前单词列表存入回溯树
        for(String word : words){
            trie.insert(word);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                backTracking2(trie,board,i,j);
            }
        }
        return new ArrayList<>(set);
    }

    // 优化后回溯
    public void backTracking2(Trie now,char[][] board,int x,int y){
        char c = board[x][y];
        // 边界条件
        if(board[x][y] == '#' || now.childrenMap.get(c) == null){
            return;
        }
        now = now.childrenMap.get(c);
        // 判断前缀树当前位置有没有单词
        if(now.word != null){
            set.add(now.word);
        }
        // 深度优先遍历
        for(int i = 0; i < 4; i++){
            int x1 = x + move[i][0];
            int y1 = y + move[i][1];
            if(x1 >= board.length || x1 < 0){
                continue;
            }
            if(y1 >= board[0].length || y1 < 0){
                continue;
            }
            // 对当前位置的单词进行标记
            board[x][y] = '#';
            backTracking2(now,board,x1,y1);
        }
        // 回溯，解除当前位置的标记
        board[x][y] = c;
    }



    public static void main(String[] args) {
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        char[][] board2 = {{'o','a','b','n'},{'o','t','a','e'},{'a','h','k','r'},{'a','f','l','v'}};
        String[] words2 = {"oa","oaa"};
        System.out.println(new 单词搜索2().findWords2(board2, words2));
    }

}

class Trie{
    public Map<Character,Trie> childrenMap;
    public String word;

    Trie(){
        this.childrenMap = new HashMap<>();
    }

    public void insert(String word){
        Trie node = this;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(node.childrenMap.get(c) == null){
                node.childrenMap.put(c,new Trie());
            }
            node = node.childrenMap.get(c);
        }
        // 循环到这里说明node已经是最后一个字母的位置了，存储当前的单词
        node.word = word;
    }

}
