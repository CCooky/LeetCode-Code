import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。
 * 返回你可以获得的最大乘积。
 */
public class 整数拆分 {
    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        int result = solution7.integerBreak(50);
        System.out.println("================86093442=====================");
        System.out.println(result);
    }

}

/**
 * 回溯版本，剪枝不超时
 */
class Solution7 {
    /**
     * 分析1：先将n拆分两个以上的正整数，那候选的正整数就是 【1，n-1】
     * 可以使用暴力回溯，进行组合，终止条件是sum=n 和sum>n；
     * 再分析时间复杂度：树的最大深度是不是就是N，当我拆成111的时候，然后树的宽度就是N，复杂度很高
     */
    public int integerBreak(int n) {
        //简单判断
        if (n < 2) return 0;
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> pathList = new ArrayList<>();
        backTracking(n, path, pathList, 1);
        System.out.println(pathList);
        return maxMultiply;
    }

    /**
     * 暴力回溯求解; 【12】、【21】是不是一样的结果，所以这是同一个集合的组合问题，然后一个元素可以反复选取，有startIndex，递归时 i不加1
     * 正常写超时了，两个终止条件if (sum == n) ，if (sum > n) return;能不能再接着剪枝呢？
     * 其实这里有一个数学常识，那就是我拆分的正整数只有相邻才可能最大，这就需要收集路径，判断路径里面的数是不是相邻，
     */
    int multiply = 1;
    int maxMultiply = 0;
    int sum = 0;

    public void backTracking(int n, List<Integer> path, List<List<Integer>> pathList, int startIndex) {
        //终止条件

        if (sum == n) {
            maxMultiply = Math.max(multiply, maxMultiply);
            pathList.add(new ArrayList<>(path));
            return;
        }
        if (sum > n) return;
        //3.回溯搜索过程，处理、递归、回溯
        for (int i = startIndex; i < n; i++) {//[1,n-1]
            /**
             * 加一个常识性的剪枝，如果即将加入的数和上一个path已经存在的不相邻或者不相等就跳过(选取数据已经是从小到大有序了）
             * 为什么不加 n=50答案就错了
             */
            if (path.size() != 0 && Math.abs(i - path.get(path.size() - 1)) > 1) {
                continue;
            }
            //
            path.add(i);
            sum = sum + i;
            multiply = multiply * i;
            //
            backTracking(n, path, pathList, i);
            //
            path.remove(path.size() - 1);
            sum = sum - i;
            multiply = multiply / i;
        }
    }
}

/**
 * DP版本，很快，复杂度为 O（N^2)
 */
class Solution8 {

    public int integerBreak(int n) {
        //3.初始化return.给的条件是 n>=2
        if (n<2) return 0;
        //1.dp
        int[] dp = new int[n + 1];
        //3.dp初始化
        dp[0] = 0;//没有意义
        dp[1] = 0;//没有意义
        dp[2] = 1;
        //2.
        for (int i = 4; i < dp.length; i++) {
            for (int j = 1; j < i; j++) { //j:[1,i-1]
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j])); //为什么还有dp[i]啊
//                dp[i] = Math.max(j * (i - j), j * dp[i - j]);
            }
        }
        return dp[n];
    }
}


