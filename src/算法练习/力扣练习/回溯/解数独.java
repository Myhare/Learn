package 算法练习.力扣练习.回溯;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 解数独 {

    int n = 0;
    // 列集合
    public Map<Integer,List<Character>> colMap ;
    // 行集合
    public Map<Integer,List<Character>> rowMap;
    // 九宫格集合(从1到9个格子里面分别出现了什么数字)
    public Map<Integer,List<Character>> geMap;

    public void solveSudoku(char[][] board) {
        n = board.length; // n其实就是9
        // 列集合
        colMap = new HashMap<>();
        rowMap = new HashMap<>();
        geMap = new HashMap<>();
        for(int i = 0; i < 9; i++){
            colMap.put(i, new ArrayList<Character>());
            rowMap.put(i, new ArrayList<Character>());
            geMap.put(i, new ArrayList<Character>());
        }
        // 初始化集合
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if (board[i][j] != '.'){
                    // 当前格子有数字，将其放入标记位,因为这是初始情况，肯定不会出现重复的数字
                    rowMap.get(i).add(board[i][j]);
                    colMap.get(j).add(board[i][j]);
                    geMap.get(getIndex(i,j)).add(board[i][j]);
                }
            }
        }
        backTracking(board,0,0);
        System.out.println( 1);

    }

    // 回溯
    public boolean backTracking(char[][] board,int x,int y){
        // 边缘条件
        if (y == n){
            // 进入下一行
            y = 0;
            x += 1;
            // 说明到了最后一行
            if (x == n){
                return true;
            }
        }
        // 遍历每一行
        // 判断当前位置可不可以填写数字
        // 当前位置是空着的,一个一个试可以填什么
        // 判断当前位置是否需要填写
        if (board[x][y] == '.'){
            for (int k = 1; k <= 9; k++) {
                // 判断有没有冲突
                if (!rowMap.get(x).contains(String.valueOf(k).charAt(0)) &&
                        !colMap.get(y).contains(String.valueOf(k).charAt(0)) &&
                        !geMap.get(getIndex(x,y)).contains(String.valueOf(k).charAt(0))){
                    // 说明当前位置可以存放当前的数字
                    board[x][y] = String.valueOf(k).charAt(0);
                    // 进行标记
                    rowMap.get(x).add(String.valueOf(k).charAt(0));
                    colMap.get(y).add(String.valueOf(k).charAt(0));
                    geMap.get(getIndex(x,y)).add(String.valueOf(k).charAt(0));
                    // 继续往后面递归
                    if (backTracking(board, x, y + 1)) {
                        return true;
                    }
                    // 删除的当前的位置
                    board[x][y] = '.';
                    rowMap.get(x).remove((Character)String.valueOf(k).charAt(0));
                    colMap.get(y).remove((Character) String.valueOf(k).charAt(0));
                    geMap.get(getIndex(x,y)).remove((Character) String.valueOf(k).charAt(0));
                }
            }
        }else {
            // 说明当前位置已经被填了数字，直接进入下一个位置
            return backTracking(board, x, y+1);
        }
        return false;

    }



    // 通过i和j获取当前是第几个小型九宫格
    public int getIndex(int i, int j){
        if (i >= 0 && i <= 2){
            if (j >= 0 && j <= 2){
                return 0;
            }else if (j >= 3 && j <= 5){
                return 1;
            }else {
                return 2;
            }
        }else if (i >= 3 && i <= 5){
            if (j >= 0 && j <= 2){
                return 3;
            }else if (j >= 3 && j <= 5){
                return 4;
            }else {
                return 5;
            }
        }else {
            if (j >= 0 && j <= 2){
                return 6;
            }else if (j >= 3 && j <= 5){
                return 7;
            }else {
                return 8;
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        new 解数独().solveSudoku(board);
        // System.out.println((char) (1 + '0'));
    }

}
