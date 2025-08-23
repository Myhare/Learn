package 算法练习.力扣练习.回溯;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 给表达式中添加运算符 {

    Set<String> set = new HashSet<>();
    int target;
    public List<String> addOperators(String num, int _target) {
        target = _target;
        // myDfs(num,1,Integer.parseInt(""+num.charAt(0)),Integer.parseInt(""+num.charAt(0)), String.valueOf(num.charAt(0)),' ');
        dfs(num,0,0,0,"");
        return new ArrayList<>(set);
    }

    /**
     * 题解方式回溯
     * @param prev    上一个运算的过程
     * @param nowTarget 当前的最后结果
     * @param path    路径
     */
    public void dfs(String num,int start,long prev,long nowTarget,String path){
        // 终止条件
        if (start == num.length()){
            if (nowTarget == target){
                set.add(path);
            }
            return;
        }

        // 从当前start到后面进行切割
        for(int i = start; i < num.length(); i++){
            // 第一个数字不能是0,如果是就剪枝,只有一个数字的时候可以
            if (num.charAt(start) == '0' && i != start){
                break;
            }
            long next = Long.parseLong(num.substring(start, i+1));
            // 判断是不是第一次运算
            if (start == 0){
                dfs(num,i+1,next,nowTarget+next,""+next);
            }else {
                // 加法
                dfs(num,i+1,+next,nowTarget+next,path+"+"+next);
                // 减法
                dfs(num,i+1,-next,nowTarget-next,path+"-"+next);
                // 乘法
                // 撤销上一次的运算
                long x = next * prev;  // 优先计算乘法
                dfs(num,i+1, x,nowTarget - prev + x, path + "*" + next);
            }
        }
    }

    /**
     * 深度递归(逻辑有一点问题，不添加运算符的时候运算结果可能出错)
     * @param num   列表
     * @param index 当前遍历的下标
     * @param temp  最后一次运算的值
     * @param nowTarget  当前运算的总结果
     * @param path   路径
     */
    public void myDfs(String num,int index,int temp,int nowTarget,String path,char lastOper){
        // 终止条件
        if (index == num.length()){
            if (nowTarget == target){
                set.add(path);
            }
            return;
        }
        int a = Integer.parseInt(String.valueOf(num.charAt(index)));
        // 加
        myDfs(num,index+1, a,nowTarget + a,path+"+"+a,'+');
        // 减
        myDfs(num,index+1, -a ,nowTarget - a,path+"-"+a,'-');
        // 乘法
        // 乘法的计算优先级比加法高，所以nowTarget应该撤销前一个计算
        if (path.length() <= 1){
            // 如果是第一个运算符，直接计算
            myDfs(num,index+1, a,nowTarget * a,path+"*"+a,'*');
        }else {
            // 撤销前一个运算，先进行乘法运算
            // 判断前一个运算是不是乘法运算
            if (lastOper != '*'){
                nowTarget = nowTarget - temp;
                int nextTemp = temp * a;
                // 因为前面已经出现过加法，后面如果出现了乘法都需要撤销运算，这里为了省时间直接最后添加'+'
                myDfs(num,index+1,nextTemp,nowTarget+nextTemp,path + "*" + a,'+');
            }else {
                // 前面只出现了乘法运算,直接进行运算
                myDfs(num,index+1,a,nowTarget*a,path+"*"+a,'*');
            }
        }
        // 不添加运算符
        // 如果过前面一个数是0，直接返回
        if (path.charAt(path.length()-1) == '0'){
            return;
        }
        // 撤销前一个运算
        nowTarget = nowTarget - temp;
        int nextTemp = 0;
        try {
            nextTemp = Integer.parseInt("" + temp + a); // 如果超出int范围会报错
        }catch (Exception e){
            return;
        }
        myDfs(num,index+1,nextTemp,nowTarget+nextTemp,path+a,lastOper);
    }

    public static void main(String[] args) {
        System.out.println(new 给表达式中添加运算符().addOperators("123", 6));
    }
}
