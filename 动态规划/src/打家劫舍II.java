import java.util.Arrays;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 */
public class 打家劫舍II {
}
class Solution25 {
    public int rob(int[] nums) {
        // 简单判断输入，因为下面会把房间分成两个部分
        if (nums.length==0) return 0;
        if (nums.length==1) return nums[0];
        // 如果只有一间房，那么下面的操作就会丢掉这一间房间的判断
        int[] route1 = Arrays.copyOfRange(nums, 0, nums.length - 2);
        int[] route2 = Arrays.copyOfRange(nums, 1, nums.length - 1);
        int money1 = robLinear(route1);
        int money2 = robLinear(route2);
        return Math.max(money1,money2);
    }

    public int robLinear(int[] nums) {
        //简单判断输入
        if (nums.length==0) return 0;
        if (nums.length==1 ) return nums[0];
        //1.dp数组大小、含义
        // dp[i]: 从i个房屋去偷，能偷到的最大金额（i个是指的前i个屋子，按照屋子排列顺序）,求dp[n]
        int n = nums.length; //房子个数
        int[] dp = new int[n+1];
        int[] money = nums;

        //3.dp数组初始化
        dp[0] = 0;
        dp[1] = money[0];

        //2.递推公式.
        // 当前的dp[i]和哪些状态相关，是不是dp[i-1]，它表示从i-1个房子去偷钱的最大值。
        // 那决定我dp[i]的就是当前第i个房子被不被偷！假如被偷的话，那第i-1个房子肯定不能被偷，
        // 不被偷的话，那第i-1个房子可以被偷，此时dp[i] = dp[i-1]啊，那有人就想我第i-1个房子到底会不会被偷呢。哎呀这就不对了，被绕出去了，看看dp数组的含义啊
        // dp[i] = dp[i-2]+money[i-1], dp[i]=dp[i-1]
        //4.遍历顺序
        for (int i = 2; i < dp.length; i++) { //
            dp[i] = Math.max(dp[i-1], dp[i-2] + money[i-1]);
        }
        return dp[n];
    }
}
