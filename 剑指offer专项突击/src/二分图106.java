import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class 二分图106 {
    public static void main(String[] args) {
        int[][] graph = new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}};
//        int[][] graph = new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        System.out.println(new 二分图106().isBipartiteBybfs(graph));
    }


    /**
     * DFS
     *
     * @param graph
     * @return
     */
    public boolean isBipartiteBydfs(int[][] graph) {
        // 已经把邻接表发给你了，就简单很多，但还是很难
        // 我将这种方法称为：红绿色盲法
        // 1. 我们从开始节点遍历，并且将它染成红色，然后将其所有的邻接节点染成绿色，再将这些绿色节点直接相连的所有节点染成红色，依次类推。
        // 2. 如果可以全部染色成功，则可以二分，如果染色过程中，出现了邻接节点和父节点颜色一样，则染色失败了，表示不能二分。
        nodeColor = new int[graph.length]; // 0：表示无颜色
        visited = new boolean[graph.length];
        dfs(0, graph, RED);
        return ans;
    }

    private static final int RED = 1;
    private static final int GREEN = 2;
    private int[] nodeColor; // 记录每个节点颜色；
    private boolean ans = true; // 是否为二分图
    private boolean[] visited; // 标记节点已访问

    // dfs
    // x：当前节点；
    private void dfs(int x, int[][] graph, int color) {
        nodeColor[x] = color;
        visited[x] = true;
        int curColor = color == RED ? GREEN : RED; //邻接点颜色
        for (int y : graph[x]) {
            if (visited[y]) { // 已经被染色
                if (nodeColor[y] == nodeColor[x]) { //颜色一致，则false
                    ans = false;
                    return;
                } else continue; // 跳过
            }
            dfs(y, graph, curColor);
        }
    }

    /**
     * BFS
     *
     * @param graph
     * @return
     */
    public boolean isBipartiteBybfs(int[][] graph) {
        bfs(0, graph);
        return result;
    }

    // BFS搜索
    private boolean result = true;
    private void bfs(int x, int[][] graph) {
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];
        int[] nodeColor = new int[graph.length];
        queue.offer(x);
        int color = GREEN;
        while (!queue.isEmpty()) {
            color = color == RED ? GREEN : RED;
            while (!queue.isEmpty()) { // 该层节点判断
                Integer node = queue.poll();
                nodeColor[node] = color;
                visited[node] = true;
                list.add(node);
            }
            // 遍历该层所有节点的所有邻接表
            for (Integer node : list) {
                for (int y : graph[node]) {
                    if (visited[y]) {
                        if (nodeColor[y] == color) {
                            result = false;
                            return;
                        }
                    } else {
                        queue.offer(y);
                    }
                }
            }
            list.clear();
        }
    }


}
