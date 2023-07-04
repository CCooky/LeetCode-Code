import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class 地图分析1162 {

    public int getRes(int[][] grid) {
        //题目：找海洋（0）离陆地（1）的最大距离
        //解法：逆向从1找0，得出所有元素的距离矩阵，采用bfs
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        //1. 初始化距离矩阵
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j}); //所有1入队
                    ans[i][j] = 0;
                    visited[i][j] = true;
                } else ans[i][j] = Integer.MAX_VALUE;
            }
        }
        if (queue.isEmpty() || queue.size() == m * n) return -1; //全部为0或1时的，异常判断
        //2. bfs
        int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int i = queue.peek()[0], j = queue.peek()[1];
            queue.poll();
            // sxzy
            for (int[] dir : direction) {
                int i_new = i + dir[0];
                int j_new = j + dir[1];
                if (0 <= i_new && i_new < m && 0 <= j_new && j_new < n && !visited[i_new][j_new]) {
                    if (ans[i_new][j_new] > ans[i][j] + 1) {
                        ans[i_new][j_new] = ans[i][j] + 1;
                        queue.offer(new int[]{i_new, j_new}); //已知距离的0入队，继续扩散
                    }
                    visited[i_new][j_new] = true;
                }
            }
        }
        // 3.
        int maxDist = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxDist = Math.max(maxDist, ans[i][j]);
            }
        }
        return maxDist;
    }
}
