package 笔试.小米;

import java.util.Scanner;

public class 小米手机通信校准 {


    // 78%
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int freq = scanner.nextInt();
        String lossList = scanner.next();
        String[] lossSplit = lossList.split(",");
        int count = 0;
        // freq:loss
        // 题目已经给了条件，freq是有序的
        for (int i = 0; i < lossSplit.length; i++) {
            String[] split = lossSplit[i].split(":");
            double nFreq = Double.parseDouble(split[0]);
            double nLoss = Double.parseDouble(split[1]);
            if (nFreq >= freq){
                if (i == 0){
                    System.out.printf("%.1f\n",nLoss);
                }else {
                    // 防止有两个或以上的相等的值
                    if (nFreq == freq){
                        if (count == 0 && i != lossSplit.length-1){
                            count++;
                            continue;
                        }
                    }
                    // 判断目标频道号的前后的值
                    String[] lastSplit = lossSplit[i - 1].split(":");
                    double lFreq = Double.parseDouble(lastSplit[0]);
                    double lLoss = Double.parseDouble(lastSplit[1]);
                    if (freq - lFreq == nFreq - freq){
                        // 取平均值
                        System.out.printf("%.1f\n", (lLoss + nLoss) / 2);
                        return;
                    }else if (freq - lFreq > nFreq - freq){
                        // 取右边
                        System.out.printf("%.1f\n", nLoss);
                        return;
                    }else {
                        // 取左边
                        System.out.printf("%.1f\n", lLoss);
                        return;
                    }
                }
            }
        }
    }

}
