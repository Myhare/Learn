package 算法练习.力扣练习.回溯;

public class 公平分发饼干 {

    int min = 800001;

    public int distributeCookies(int[] cookies, int k) {
        int n = cookies.length;
        // 表示每个孩子饼干的个数
        int[] f = new int[k+1];
        dfs(0,cookies,f);
        return min;
    }


    public void dfs(int index, int[] cookies, int[] f){
        if (index >= cookies.length){
            // 找出当前所有分到饼干的孩子的最大值
            int max = 0;
            for (int i = 1; i < f.length; i++) {
                max = Math.max(max,f[i]);
            }
            // 维护最小值
            min = Math.min(min, max);
            return;
        }

        // 剪枝，如果剩下的饼干不够小朋友分了，直接返回
        int count = 0; // 剩下没有饼干的小朋友
        for (int i = 1; i < f.length; i++) {
            // 如果某个孩子的饼干数量比最小不公平数还要大，直接返回
            if (f[i] > min){
                return;
            }
            if (f[i] == 0){
                count++;
            }
        }
        if (count > cookies.length - index){
            return;
        }


        // 当前位置的饼干一个一个放到每个孩子中去
        for (int i = 1; i < f.length; i++) {
            // 剪枝,如果是第一个零食包，直接给一个小朋友就行，给哪个结果都一样,所以只需要判断给第一个小孩的情况就可以了
            if (index == 0 && i > 1){
                return;
            }

            f[i] += cookies[index];
            dfs(index + 1, cookies,f);
            f[i] -= cookies[index];

        }

    }

    public static void main(String[] args) {
        int[] cookies = {8,15,10,20,8};
        System.out.println(new 公平分发饼干().distributeCookies(cookies, 2));
    }

}
