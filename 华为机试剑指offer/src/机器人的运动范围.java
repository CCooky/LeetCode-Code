public class 机器人的运动范围 {
}

class Solution34 {
    // m,n——矩阵的大小，k障碍物标记
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        //从这个【0，0】位置开始搜索即可
        dfs(m,n,k,0,0,visited);
        return result;
    }

    //需要一个visited数组，标识已经到达过的点，防止重复到达，因为每个点均可以上下左右四个方向搜索
    //i,j表示当前机器人想到达的点，
    int result = 0;
    public void dfs(int m, int n, int k, int i, int j, boolean[][] visited) {
        //2.终止条件。如果该点越界或者有障碍物或已经到达过，那么就无法到达，return
        if (i < 0 || i > m - 1 || j < 0 || j > n - 1 || getSum(i)+getSum(j)>k
        || visited[i][j]==true){
            return;
        }
        //到这一步，说明该点可以到达。上下左右四个方向
        visited[i][j] = true;
        result++;
        dfs(m, n, k, i+1, j, visited);
        dfs(m, n, k, i-1, j, visited);
        dfs(m, n, k, i, j+1, visited);
        dfs(m, n, k, i, j-1, visited);
    }

    //函数：获取某个数的数位之和
    public int getSum(int num) {
        int sum = 0;
        while (num != 0) {
            int i = num % 10;
            sum += i;
            num = num / 10;
        }
        return sum;
    }
}
