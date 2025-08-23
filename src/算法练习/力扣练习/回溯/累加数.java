package 算法练习.力扣练习.回溯;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class 累加数 {

    String num;
    boolean isOk = false;

    /*
        累加数每一个数都是前两个数之和
     */

    public boolean isAdditiveNumber(String _num) {
        if (_num.length() < 3){
            return false;
        }
        num = _num;
        backTracking(0,new ArrayList<>());
        return isOk;
    }

    // 回溯递归
    public void backTracking(int start, List<String> path){
        if (isOk){
            return;
        }
        // 终止条件
        if (start == num.length()){
            if (path.size() >= 3){
                BigInteger b1 = new BigInteger(path.get(path.size()-3));
                BigInteger b2 = new BigInteger(path.get(path.size()-2));
                BigInteger b3 = new BigInteger(path.get(path.size()-1));
                if (b1.add(b2).compareTo(b3) == 0){
                    isOk = true;
                }
            }
            return;
        }


        for(int i = start; i < num.length(); i++){
            // 剪枝
            if (num.charAt(start) == '0' && i != start){
                break;
            }
            // 获取子数据
            BigInteger val = new BigInteger(num.substring(start, i + 1));
            // 判断是不是第一次添加
            if (path.size()<2){
                path.add(val.toString());
                backTracking(i+1,path);
                // 删除最后一个位置
                path.remove(path.size()-1);
            }else {
                // 判断当前数字是不是path前两个数字的和
                BigInteger prev1 = new BigInteger(path.get(path.size()-2));
                BigInteger prev2 = new BigInteger(path.get(path.size()-1));
                if (prev1.add(prev2).compareTo(val) == 0){
                    // 说明截止当前位置还是一个累加数
                    path.add(val.toString());
                    backTracking(i+1,path);
                    path.remove(path.size()-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new 累加数().isAdditiveNumber("101"));
    }

}
