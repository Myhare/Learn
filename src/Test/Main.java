package Test;


import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int userCount = in.nextInt();
        int[] arr = new int[userCount];
        // 注意 hasNext 和 hasNextLine 的区别
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }

        int like = 0;
        int comment = 0;

        for (int i = 0; i < userCount; i++) {
            if (arr[i] == 1){
                comment++;
            }else if (arr[i] == 2){
                like++;
            }else if (arr[i] == 3){
                if (like > comment){
                    like++;
                }else if (like < comment){
                    comment++;
                }else {
                    like++;
                    comment++;
                }
            }
        }
        System.out.print(comment + " " + like);
    }

}
