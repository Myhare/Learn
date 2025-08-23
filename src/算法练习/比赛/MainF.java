package 算法练习.比赛;

import java.util.ArrayList;
import java.util.Scanner;

public class MainF {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();   // t天的时间
        scanner.close();
        int count = 0;
        ArrayList<Long> list = new ArrayList<>();

        long sumDay = 0;
        long i = 2;
        for (long j = 2; i + sumDay <= t; j++){
            sumDay = sumDay + i;
            list.add(i);
            i = (long) Math.pow(2,j);
        }

        if (sumDay < t){
            list.add(t-sumDay);
        }

        for (int j = 0; j < list.size(); j++) {
            count += (j+1)*list.get(j);
        }

        System.out.println(count);

    }
}
