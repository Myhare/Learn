package 笔试.bilibili;

import java.util.HashMap;

public class Double数 {

    // 1 <= n <= 10^12

    public int DoubleNumber (long n) {
        // write code here
        int count = 0;

        for (long i = 1; i <= n; i++) {
            String s = String.valueOf(i);
            if (s.length() % 2 != 0){
                // 直接加一个0
                i = i * 10 - 1;
                continue;
            }
            if (isDouble(s)){
                count++;
            }
        }

        return count;
    }

    public int DoubleNumber2 (long n) {
        // write code here
        int count = 0;

        String s = String.valueOf(n);
        int len = s.length();

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(2, 9);
        map.put(4, 99);
        map.put(6, 999);
        map.put(8, 9999);
        map.put(10, 99999);
        map.put(12, 999999);


        if (len % 2 == 0){
            // 说明是双数
            Integer nums = map.get(len - 2);
            count += nums;
            StringBuilder tempS = new StringBuilder("1");
            for (int i = 0; i < len - 1; i++) {
                tempS.append("0");
            }
            for (long t = Long.parseLong(tempS.toString()); t < n; t ++){
                if (isDouble(String.valueOf(t))){
                    count++;
                }
            }
        }else {
            // 说明是单数
            Integer nums = map.get(len - 1);
            count += nums;
            StringBuilder tempS = new StringBuilder("1");
            for (int i = 0; i < len - 1; i++) {
                tempS.append("0");
            }
            for (long t = Long.parseLong(tempS.toString()); t < n; t ++){
                if (isDouble(String.valueOf(t))){
                    count++;
                }
            }
        }

        return count;
    }

    // 暴力 超时
    public boolean isDouble(String s){
        if (s.length() % 2 != 0){
            return false;
        }
        int left = 0;
        int right = s.length()/2;

        while (right < s.length()){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right++;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Double数().DoubleNumber2(3154354));
    }

}
