package 算法练习.力扣练习.广度优先;

import java.util.*;

public class 课程表 {

    /*
        你这个学期必须选修 numCourses 门课程，记为0到numCourses - 1 。
        在选修某些课程之前需要一些先修课程。 先修课程按数组prerequisites 给出，其中prerequisites[i] = [ai, bi] ，
        表示如果要学习课程ai 则 必须 先学习课程 bi 。

        例如，先修课程对[0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
        请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
     */

    /*
         拓扑排序问题
         相当于很多个节点，每一个节点都有一个“度”，只有当这个度为0的时候这个课程才能被选修
     */

    /**
     * @param numCourses 有多少门课程
     * @param prerequisites 选修课程的详细信息，需要先选修什么
     * @return
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // 用来表示各个课程的入度
        Map<Integer, Integer> map = new HashMap<>();
        // 创建第二个map集合，表示依赖当前课程的课(出度)
        HashMap<Integer, List<Integer>> relyOnMap = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            map.put(i,0);
        }

        // 初始化各个课程的入度
        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0];  // 表示当前要学习的课程
            int b = prerequisites[i][1];  // 表示想要学习当前课程需要提前学习的课程

            // 想要学习a的课程，就需要先学习map.get(a)的数量的课程
            map.put(a,map.get(a)+1);

            // 将需要学习这个课程的相邻课程加入到队列中
            if (!relyOnMap.containsKey(b)){
                relyOnMap.put(b,new ArrayList<>());
            }
            relyOnMap.get(b).add(a);
        }

        // 创建一个队列，表示当前队列
        Queue<Integer> queue = new LinkedList<>();
        // 将所有入度为0的课程先入队
        for (Integer key : map.keySet()) {
            if (map.get(key)==0){
                queue.offer(key);
            }
        }

        // 广度优先遍历
        while (!queue.isEmpty()){
            // 弹出当前课程
            Integer curriculum = queue.poll();

            // 如果当前课程没有依赖的课程，直接跳出当前循环
            if (!relyOnMap.containsKey(curriculum)) {
                continue;
            }

            // 获取需要完成当前课程的课，并且将度减一
            List<Integer> list = relyOnMap.get(curriculum);
            for (Integer key : list) {
                // val为依赖当前课程的度
                Integer val = map.get(key);
                map.put(key,--val);
                if (val == 0){
                    queue.offer(key);
                }
            }
        }
        // 遍历课程的入度，如果有的课程还有入度说明不能完成课程
        for (Integer key : map.keySet()) {
            if (map.get(key)!=0){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[][] course = new int[][]{
                {3,0}, {3,1}, {4,1}, {4,2}, {5,3}, {5,4}
        };
        int[][] prerequisites = {{1,0}};
        // boolean res = canFinish(6, course);
        boolean res = canFinish(2, prerequisites);
        System.out.println(res);
    }

}
