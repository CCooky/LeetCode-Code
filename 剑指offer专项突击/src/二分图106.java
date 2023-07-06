import sun.security.util.KnownOIDs;

public class 二分图106 {
    public static void main(String[] args) {
//        int[][] graph = new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        int[][] graph = new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        System.out.println(new 二分图106().isBipartite(graph));
    }


    private static final int RED = 1;
    private static final int GREEN = 2;
    private int[] nodeColor; // 记录每个节点颜色；
    private boolean ans = true; // answer

    public boolean isBipartite(int[][] graph) {
        // 已经把邻接表发给你了，就简单很多，但还是很难
        // 我将这种方法称为：红绿色盲法
        // 1. 我们从开始节点遍历，并且将它染成红色，然后将其所有的邻接节点染成绿色，再将这些绿色节点直接相连的所有节点染成红色，依次类推。
        // 2. 如果可以全部染色成功，则可以二分，如果染色过程中，出现了邻接节点和父节点颜色一样，则染色失败了，表示不能二分。
        nodeColor = new int[graph.length]; // 0：表示无颜色
        dfs2(0, 0, graph, RED);
        return true;
    }

    // DFS搜索
    // pre：当前节点父节点；x：当前节点；color：当前节点要被染的颜色
    private void dfs(int pre, int x, int[][] graph, int color) {
        nodeColor[x] = color;
        int curColor = color == RED ? GREEN : RED; //邻接点颜色
        for (int y : graph[x]) {
            if (y == pre) continue;
             if (nodeColor[y] == 0) { //未被染色
                nodeColor[y] = curColor;
                dfs(x, y, graph, curColor);
            } else if (nodeColor[y] == nodeColor[x]) { // 已经被染色，且颜色一致，则false
                ans = false;
                return;
            }
            // 已经被染色，颜色不一致，则跳过该节点，这里已经跳过了，不往下dfs
        }
    }

    private void dfs2(int pre, int x, int[][] graph, int color) {
        nodeColor[x] = color;
        int curColor = color == RED ? GREEN : RED; //邻接点颜色
        for (int y : graph[x]) {
            if (y == pre) continue;// 遇到父节点跳过
            if (nodeColor[y] != 0 && nodeColor[y] == nodeColor[x]) { // 已经被染色，且颜色一致，则false
                ans = false;
                return;
            }
            if (nodeColor[y] != 0 && nodeColor[y] != nodeColor[x]) continue; // 已经被染色，且颜色不一致，则颜色符合条件，跳过该节点避免重复染色
            dfs2(x, y, graph, curColor);
        }
    }

    // BFS搜索
}
