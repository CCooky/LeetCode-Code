import java.util.Arrays;

public class 不同路径II {
    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{{0,1},{0,0}};
        Solution6 solution6 = new Solution6();
        int paths = solution6.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(paths);
        int[] nums = new int[]{1,2,3};
        int sum = Arrays.stream(nums).sum();
    }
}

class Solution6 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(m==0 || n==0) return 0;
        if(obstacleGrid[0][0]==1 ||obstacleGrid[m-1][n-1]==1){
            return 0;
        }
        //dp[i][j] : 到达该索引位置的不同路径数量
        int[][] dp = new int[m][n];

        //3.
        dp[0][0] = 1;
        for(int i=1; i<n; i++){ //第一行
            if(obstacleGrid[0][i] == 1){
                while(i<n){
                    dp[0][i] = 0; i++;
                }
                break;
            }else dp[0][i] = 1;
        }
        for(int i=1; i< m; i++){ //第一列
            if(obstacleGrid[i][0] == 1){
                while(i < m){
                    dp[i][0] = 0; i++;
                }
                break;
            }else dp[i][0] = 1;
        }

        //2. 如果该位置有物体，直接为0即可；然后就是dp[i][j] = dp[i-1][j] + d[i][j-1];
        for(int i = 1; i<dp.length; i++){
            for(int j = 1; j<dp[0].length; j++){
                if(obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        //
        return dp[m-1][n-1];
    }
}
