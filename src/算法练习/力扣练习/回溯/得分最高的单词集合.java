package 算法练习.力扣练习.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 得分最高的单词集合 {

    public int maxScore = 0;

    int[] score;

    public int maxScoreWords(String[] words, char[] letters, int[] _score) {

        int[] arr = new int[26];

        // 初始化数组
        for(int i = 0; i < letters.length; i++){
            arr[letters[i] - 'a'] += 1;
        }
        score = _score;
        boolean[] flags = new boolean[words.length];
        dfs(arr,words,flags,0);

        return maxScore;

    }

    // 深度优先遍历每个单词
    // 当前的单词下标  标记位  单词列表  当前单词是否已经写过了  当前得分
    public void dfs(int[] arr, String[] words, boolean[] flags, int nowVal){

        maxScore = Math.max(maxScore, nowVal);

        // 遍历添加每一个单词
        for (int i = 0; i < words.length; i++) {
            if (flags[i]){
                continue;
            }
            // 尝试拼接当前单词
            int tVal = pingjie(words[i], arr);
            if (tVal == -1){
                // 说明不能拼接当前单词
                continue;
            }
            // 到这里说明当前单词可以拼接
            flags[i] = true;
            dfs(arr, words, flags,nowVal+tVal);
            // 将单词中字母重新放回去
            for (int j = 0; j < words[i].length(); j++) {
                arr[words[i].charAt(j) - 'a'] += 1;
            }
            flags[i] = false;
        }

    }

    public int pingjie(String word, int[] arr){
        int tempVal = 0;
        int[] tempArr = Arrays.copyOfRange(arr,0,arr.length);
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (tempArr[chars[i] - 'a'] <= 0){
                return -1;
            }
            // 当前字母减一
            tempArr[chars[i] - 'a'] -= 1;
            tempVal += score[chars[i] - 'a'];
        }
        // 复制回去
        for (int i = 0; i < tempArr.length; i++) {
            arr[i] = tempArr[i];
        }
        return tempVal;
    }

    public static void main(String[] args) {
        String[] words = {"dog","cat","dad","good"};
        char[] letters = {'a','a','c','d','d','d','g','o','o'};
        int[] score = {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};

        String[] words2 = {"xxxz","ax","bx","cx"};
        char[] letters2 = {'z','a','b','c','x','x','x'};
        int[] score2 = {4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,10};

        System.out.println(new 得分最高的单词集合().maxScoreWords(words2,letters2,score2));
    }

}
