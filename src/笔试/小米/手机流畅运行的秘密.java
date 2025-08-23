package 笔试.小米;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 手机流畅运行的秘密 {

    public static class Electric{


        // 消耗的电量
        public int consume;

        // 需要运行时候的最少电量
        public int electric;


        public Electric(int consume, int electric) {
            this.electric = electric;
            this.consume = consume;
        }

        @Override
        public String toString() {
            return "Electric{" +
                    "consume=" + consume +
                    ", electric=" + electric +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String[] split = s.split(",");
        ArrayList<Electric> list = new ArrayList<>();
        for (String s1 : split) {
            String[] split1 = s1.split(":");
            list.add(new Electric(Integer.parseInt(split1[0]), Integer.parseInt(split1[1])));
        }
        // 排序
        list.sort((o1, o2) -> {
            if (o1.electric == o2.electric){
                return o1.consume - o2.consume;
            }else {
                return o1.electric - o2.electric;
            }
        });
        // 获取最少电量
        int e = list.get(0).electric;

        // 维护上一个的电量
        int lastE = e;

        for (int i = 1; i < list.size(); i++) {

        }

    }

}
