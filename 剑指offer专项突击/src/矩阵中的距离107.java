import java.util.*;

public class 矩阵中的距离107 {
    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1},
        };
        int[][] ans = new 矩阵中的距离107().getRes(mat);
        System.out.println(Arrays.deepToString(ans));
    }

    public int[][] getRes(int[][] mat) {
        // 矩阵的搜索类型：一般是DFS递归回溯法，但这个要找最近的，我们只能BFS搜索,借助辅助数据结构队列实现
        // 其次矩阵的每个位置都要搜索一次
        int[][] ans = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                ans[i][j] = bfs(mat, i, j);
            }
        }
        return ans;
    }

    private int bfs(int[][] mat, int i, int j) {
        if (mat[i][j] == 0) return 0;
        int distance = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        List<int[]> list = new ArrayList<>();
        boolean[][] visited = new boolean[mat.length][mat[0].length];

        queue.offer(new int[]{i, j}); // 与Tree的BFS不同，这里要防止某个节点多次入队
        visited[i][j] = true;
        while (true) { //外层还有一个循环
            distance++;
            while (!queue.isEmpty()) { // 判断一个外圈的所有元素
                int[] ints = queue.poll();
                i = ints[0];
                j = ints[1];
                if (0 <= i + 1 && i + 1 < mat.length && 0 <= j && j < mat[0].length && !visited[i + 1][j]) {
                    if (mat[i + 1][j] == 0) return distance;
                    list.add(new int[]{i + 1, j});
                    visited[i + 1][j] = true;
                }
                if (0 <= i - 1 && i - 1 < mat.length && 0 <= j && j < mat[0].length && !visited[i - 1][j]) {
                    if (mat[i - 1][j] == 0) return distance;
                    list.add(new int[]{i - 1, j});
                    visited[i - 1][j] = true;
                }
                if (0 <= i && i < mat.length && 0 <= j + 1 && j + 1 < mat[0].length && !visited[i][j + 1]) {
                    if (mat[i][j + 1] == 0) return distance;
                    list.add(new int[]{i, j + 1});
                    visited[i][j + 1] = true;
                }
                if (0 <= i && i < mat.length && 0 <= j - 1 && j - 1 < mat[0].length && !visited[i][j - 1]) {
                    if (mat[i][j - 1] == 0) return distance;
                    list.add(new int[]{i, j - 1});
                    visited[i][j - 1] = true;
                }
            }
            for (int[] ints1 : list) { //没有找到，下一个外圈入队列
                queue.offer(ints1);
            }
            list.clear();
        }
    }

    // leetcode官方题解：逻辑逆着写，从0找1；先把所有的0找出来，然后一依次bfs找1，找到一个1后，就可以知道这个最短为1，然后这个1入队列，由他又可以继续向外扩展。
    // 求每个元素到最近0的距离：为什么只能从0找1呢，因为我们能已知0元素的距离是0，但对于其他元素我们无法直接得出，也就不能由它进行扩散；
    public int[][] getResByLC(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n]; // 结果数组
        Queue<int[]> queue = new ArrayDeque<>();
        List<int[]> list = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];
        // 1、距离数组初始化，0元素为0，其他元素设置为最大值
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    ans[i][j] = 0;
                    queue.offer(new int[]{i, j}); // 0入队
                    visited[i][j] = true; // 标记已遍历
                } else ans[i][j] = Integer.MAX_VALUE;
            }
        }
        // bfs
        int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // 方向数组
        while (!queue.isEmpty()) {
            int i = queue.peek()[0], j = queue.peek()[1];
            queue.poll();
            // 上下左右
            for (int[] dir : direction) {
                int i_new = i + dir[0];
                int j_new = j + dir[1];
                if (0 <= i_new && i_new < m && 0 <= j_new && j_new < n && !visited[i_new][j_new]) {
                    visited[i_new][j_new] = true;
                    if (ans[i_new][j_new] > ans[i][j] + 1) {
                        ans[i_new][j_new] = ans[i][j] + 1;
                        list.add(new int[]{i_new, j_new}); // 已知距离的1入队，继续扩散
                    }
                }
            }
            queue.addAll(list);
            list.clear();
        }
        return ans;
    }


}
