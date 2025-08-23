package 算法练习.蓝桥杯练习.国赛2020;

import java.util.LinkedList;

public class B扩散 {

    public class Node{
        public String name;

        public Node(String name) {
            this.name = name;
        }
    }
    // 使用BFS广度优先遍历方法
    public void test(){
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node("A"));
        System.out.println(queue.get(0).name);
    }


    public static void main(String[] args) {
        new B扩散().test();
    }

}
