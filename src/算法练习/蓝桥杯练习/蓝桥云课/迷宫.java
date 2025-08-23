package 算法练习.蓝桥杯练习.蓝桥云课;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 迷宫 {



    static class Node{
        int x;
        int y;
        String str;
        public Node(int x , int y ,String str){
            this.x =x;
            this.y =y;
            this.str = str;
        }
    }

    static char[][]  graph = new char[30][50];
    static char[] path = {'D','L','R','U'};
    static int[] r = {0,-1,1,0};
    static int[] c = {1,0,0,-1};
    static int[][] visited = new int[30][50];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<30;i++){
            graph[i]=sc.nextLine().toCharArray();
        }
        sc.close();

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, ""));
        visited[0][0] =1;
        String shunxv ="";
        while(!queue.isEmpty()){
            Node  t = queue.poll();
            int x1 = t.x;
            int y1 = t.y;
            String str1 = t.str;
            if(x1==29&&y1==49){
                shunxv = str1;
                break;
            }
            for(int i=0;i<4;i++){
                int x2= x1+c[i];
                int y2= y1+r[i];
                if(x2>=0&&x2<=29&&y2>=0&&y2<=49&&graph[x2][y2]=='0'&&visited[x2][y2]!=1){
                    queue.add(new Node(x2, y2, str1+path[i]));
                    visited[x2][y2]=1;
                }
            }
        }
        System.out.println(shunxv);







    }

}
