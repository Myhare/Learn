package 笔试.众安;

public class A {

    public int[] constructArr (int[] a) {
        int n = a.length;
        int[] reArr = new int[n];

        long t = 1;
        for (int i = 0; i < a.length; i++) {
            t *= a[i];
        }

        for (int i = 0; i < n; i++) {
            reArr[i] = (int)t / a[i] ;
        }

        return reArr;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] ints = new A().constructArr(a);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

}
