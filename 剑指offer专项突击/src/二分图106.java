import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class 二分图106 {
    public static void main(String[] args) {
        int[][] graph = new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}};
//        int[][] graph = new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        System.out.println(new 二分图106().isBipartite(graph));
    }


    public boolean isBipartite(int[][] graph) {
        // 已经把邻接表发给你了，就简单很多，但还是很难
        // 我将这种方法称为：红绿色盲法
        // 1. 我们从开始节点遍历，并且将它染成红色，然后将其所有的邻接节点染成绿色，再将这些绿色节点直接相连的所有节点染成红色，依次类推。
        // 2. 如果可以全部染色成功，则可以二分，如果染色过程中，出现了邻接节点和父节点颜色一样，则染色失败了，表示不能二分。
        nodeColor = new int[graph.length]; // 0：表示无颜色
//        dfs(0, 0, graph, RED);
        bfs(0, 0, graph);
        return ans;
    }

    private static final int RED = 1;
    private static final int GREEN = 2;
    private int[] nodeColor; // 记录每个节点颜色；
    private boolean ans = true; // 是否为二分图
    // DFS搜索
    // pre：当前节点父节点；x：当前节点；color：当前节点要被染的颜色
    private void dfs(int pre, int x, int[][] graph, int color) {
        nodeColor[x] = color;
        int curColor = color == RED ? GREEN : RED; //邻接点颜色
        for (int y : graph[x]) {
            if (y == pre) continue;// 遇到父节点跳过
            if (nodeColor[y] != 0 && nodeColor[y] == nodeColor[x]) { // 已经被染色，且颜色一致，则false
                ans = false;
                return;
            }
            if (nodeColor[y] != 0 && nodeColor[y] != nodeColor[x]) continue; // 已经被染色，且颜色不一致，则颜色符合条件，跳过该节点避免重复染色
            dfs(x, y, graph, curColor);
        }
    }

    // BFS搜索
    private void bfs(int pre, int x, int[][] graph) {
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];
        queue.offer(x);
        int curColor = RED;
        while (!queue.isEmpty()) {
            while (!queue.isEmpty()) {
                Integer pollnode = queue.poll();
                nodeColor[pollnode] = curColor; // 该节点染色
                visited[pollnode] = true;
                curColor = curColor == RED ? GREEN : RED;
                for (int node : graph[pollnode]) { // 邻接点
                    if (visited[node]) {
                        if (nodeColor[pollnode] == nodeColor[node]) {
                            ans = false;
                            return;
                        }
                    } else { // 未染色
                        nodeColor[node] = curColor; // 染色
                        visited[node] = true; // 已访问
                        list.add(node); // 入队，需要判断它的下一层
                    }
                }
            }
            queue.addAll(list);
            list.clear();
        }
    }
}
