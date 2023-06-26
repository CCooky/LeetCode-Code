public class 礼物的最大价值 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,2},
                {5,6},
                {1,1}
        };
        getRes(grid);
    }

    public static int getRes(int[][] grid) {
        //
        if (grid.length==0 || grid[0].length==0) return 0;
        //1、dp[i][j] 到达该棋盘索引[i,j]位置能拿到的最大价值；
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        //3.chushihua
        dp[0][0] = grid[0][0];
        int sum = grid[0][0];
        for (int i = 1; i < n; i++) {
            sum += grid[0][i];
            dp[0][i] = sum;
        }
        sum = grid[0][0];
        for (int i = 1; i < m; i++) {
            sum += grid[i][0];
            dp[i][0] = sum;
        }
        //2、dp[i][j]: MAX(dp[i-1][j]+ 当前位置的礼物，(dp[i][j-1]+ 当前位置的礼物 ）
        for (int i = 1; i <dp.length; i++) {
            for (int j =1; j <dp[0].length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j]);
            }
        }
        System.out.println(dp[m-1][n-1]);
        return dp[m-1][n-1];
    }
}

