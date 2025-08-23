package 算法练习;

public class Backup {

    class Node{
        public int item;
        private Node next;

        Node( int item,Node next){
            this.item=item;
            this.next=next;
        }
    }

    private Node head;
    private int size;

    public void add(int element) {

        Node node=new Node(element,null);
        Node tail=getTail();
        if(tail==null){
            this.head=node;
        }
        else{
            tail.next=node;
        }
        this.size++;
    }
    private Node getTail(){
        if(this.head==null){
            return null;
        }
        Node node=this.head;
        while(true){
            if(node.next==null)
                break;
            node=node.next;
        }
        return node;
    }

    public int size() {
        return this.size;
    }

    private  Node headC;
    private  Node headB;
    private  int sizeB;
    private  int sizeC;

    public Node getHeadC(){
        Node node=this.head;
        Node C = null;
        while(node.next!=null) {
            if (node.item > 0) {
                if (headC == null){
                    headC = new Node(node.item,null);  // 创建一个新的节点，用来表示headB的头结点
                    C = headC;
                } else{
                    headC.next = new Node(node.item,null);
                    headC = headC.next;
                }
                this.sizeC++;
            }
            node = node.next;

        }
        return C;
    }
    public Node getHeadB(){
        Node node=this.head;
        Node B = null;
        while(node!=null) {
            if (node.item < 0) {
                if (headB == null){
                    headB = new Node(node.item,null);  // 创建一个新的节点，用来表示headB的头结点
                    B = headB;  // 将头结点赋值给B
                }
                else{
                    headB.next = new Node(node.item,null);
                    headB = headB.next;
                }
                this.sizeB++;
            }
            node = node.next;
        }
        return B;
    }


    public static void main(String[] args) {
        Backup breakUp=new Backup();
        breakUp.add(1);
        breakUp.add(-2);
        breakUp.add(3);
        breakUp.add(4);
        breakUp.add(-5);
        breakUp.add(9);
        breakUp.add(-8);
        Node B= breakUp.getHeadB();
        Node C= breakUp.getHeadC();
        int i=0;
        Node node=C;
        while (i < breakUp.sizeC){
            System.out.println(node.item);
            node=node.next;
            i++;
        }
    }
}
