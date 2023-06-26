import java.util.*;

public class 最长递增子序列 {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        Solution32 solution32 = new Solution32();
        solution32.lengthOfLIS(nums);
    }

}

class Solution32 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        //1.dp数组；
        // dp[i]: 从i个元素里面找，以第i个元素（nums[i-1])结尾的最长递增子序列长度。
        int[] dp = new int[n+1]; //一共有n个元素
        //3.dp数组初始化
        dp[0] = 0;//没有意义，不用管
        dp[1] = 1; //n>=1

        //2.递推公式
        // 对于dp[i-1]来说，那么如果我的第i个元素，大于第i-1个元素，那么是不是dp[i]=dp[i-1]+1啊。
        // 那不仅仅和dp[i-1]比啊，要和第i个元素前面所有的比较啊，应该去找到满足这个条件的dp[j],0<j<i 取这里面的最大值，
        // 也就是取 dp[i] = max(dp[j]) +1, 0<j<i，nums[i-1]>nums[j-1]。
        // 还有可能第i个元素比前面的都小呢，对吧，那就是前面没有找到一个小的，那此时dp[i]=1了，就他自己
        //4.遍历顺序
        for (int i = 2; i < dp.length; i++) { //从i个元素里面
            //1.判断第i个元素前面，从前面i-1个元素找，有没有比他小的，有那就找出小的那堆里面dp[i]最大的出来
            boolean flag = false;
            int dpjMax = dp[1];
            for (int j = 1; j <= i - 1; j++) { //从1~i-1个元素里面
                if (nums[i - 1] > nums[j - 1]) {
                    dpjMax = Math.max(dpjMax, dp[j]);
                    flag = true;
                }
            }
            //2.有比第i个元素小的
            if (flag) dp[i] = dpjMax + 1;
            else dp[i] = 1;
        }
        // 最后返回结果是，整个数组内最长递增子序列长度，所以是不是我们取dp数组里面最大值啊
        int dpMax = 0; //这里0是没有意义的，
        for (int i = 1; i < dp.length; i++) {
            dpMax = Math.max(dp[i], dpMax);
        }
        return dpMax;
    }


    /**
     * 回溯
     */
    public int lengthOfLIS2(int[] nums) {
        //输入的简单判断
        List<List<Integer>> pathList = new ArrayList<>();
        if (nums.length == 1) return 1;
        if (nums.length == 0) return 0;
        List<Integer> path = new ArrayList<>();
        int startIndex = 0;
        backTracking(nums, path, pathList, startIndex);
        int lenth = 0;
        System.out.println(pathList);
        for (List<Integer> path1 : pathList) {
            lenth = path1.size() > lenth ? path1.size() : lenth;
        }
        return lenth;
    }

    //回溯，组合问题，需要树层去重，但是不能先对数据集合进行排序。使用set进去数值去重！
    // 1.参数；需要startIndex进行组合的去重（【12】【21】），每个元素使用一次i+1
    public void backTracking(int[] nums, List<Integer> path, List<List<Integer>> pathList, int startIndex) {
        //2.终止条件。这里组合长度没有要求，可以只有一个（在回溯搜索里面判断）
        if (path.size() >= 1) {
            pathList.add(new ArrayList<>(path));
        }
        //3.回溯搜索；处理、递归、回溯
        Set<Integer> set = new HashSet<>();  // 定义在内部，每个树层的for循环开始前都有一个自己的空Set
        for (int i = startIndex; i < nums.length; i++) {
            // 做树层去重的判断
            if (set.contains(nums[i])) {
                continue;
            }
            // 做非严格递增的判断,如果比path里面最后一个元素大，就不是递增的. 注意path要不为空的哦！！！
            if (path.size() != 0 && nums[i] <= path.get(path.size() - 1)) {
                continue;
            }
            path.add(nums[i]);
            set.add(nums[i]);
            backTracking(nums, path, pathList, i + 1);
//            set.remove(nums[i]); //不remove
            path.remove(path.size() - 1);
        }
    }
}
