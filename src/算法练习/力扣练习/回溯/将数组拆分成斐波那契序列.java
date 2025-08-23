package 算法练习.力扣练习.回溯;

import java.util.ArrayList;
import java.util.List;

public class 将数组拆分成斐波那契序列 {

    public boolean isOk = false;

    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> list = new ArrayList<>();
        backTracking(0,num,list);
        return list;
    }

    // 1101111

    public void backTracking(int start, String num,List<Integer> list){
        if (isOk){
            return;
        }
        if (start == num.length()){
            if (list.size() >= 3){
                isOk = true;
            }
            return;
        }

        for (int i = start; i < num.length(); i++){
            // 不能含有前导0
            if (num.charAt(start) == '0' && i != start){
                return;
            }
            int subI = 0;
            try {
                subI = Integer.parseInt(num.substring(start, i + 1));
            } catch (NumberFormatException e) {
                return;
            }
            if (list.size() < 2){
                list.add(subI);
                backTracking(i+1,num,list);
                if (isOk){
                    return;
                }
                list.remove(list.size()-1);
            }else {
                // 判断是否可以添加进去
                Integer integer1 = list.get(list.size() - 1);
                Integer integer2 = list.get(list.size() - 2);
                if (subI == integer1 + integer2){
                    list.add(subI);
                    backTracking(i+1,num,list);
                    if (isOk){
                        return;
                    }
                    list.remove(list.size()-1);
                }
            }

        }

    }

    public static void main(String[] args) {
        System.out.println(new 将数组拆分成斐波那契序列().splitIntoFibonacci("1101111"));
    }

}
