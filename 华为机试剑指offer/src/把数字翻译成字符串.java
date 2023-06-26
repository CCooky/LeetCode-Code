import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 把数字翻译成字符串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        getRes(num);
        getResDP(num);
    }

    /**
     * [[5, 0, 6], [5, 06]] 第二种方案不成立，因为没有 06 对应的字符，这个题目没有明确说啊，有问题出的，测试用例是这样写的
     */
    //这是一个连续切割问题啊，问多少种切割方案让切割出的元素均满足要求。回溯法
    //startIndex——分割线，每次分割出的部分【startIndex, i】，将num转换成String做，因为方便获取substring
    public static int getRes(int num) {
        backTracking(String.valueOf(num), 0);
        System.out.println(pathList.size());
        System.out.println(pathList);
        return pathList.size();
    }

    public static List<String> path = new ArrayList<>();
    public static List<List<String>> pathList = new ArrayList<>();

    // startIndex——既是分割线，也是数据集切换
    public static void backTracking(String num, int startIndex) {
        //2.stop
        if (startIndex == num.length()) {
            pathList.add(new ArrayList<>(path));
            return;
        }
        //3.回溯过程（处理递归回溯）
        for (int i = startIndex; i < num.length(); i++) {
            //判断剪枝; 最多两位，然后大小不超过25
            String substring = num.substring(startIndex, i + 1);
            if (Integer.parseInt(substring) > 25 || i - startIndex + 1 > 2) {
                continue;
            }
            //加一个判断[[5, 0, 6], [5, 06]]的，即两个数位是第一位不能为0
            if (i - startIndex + 1 == 2 && num.charAt(startIndex) == '0') {
                continue;
            }
            path.add(substring);
            backTracking(num, i + 1);
            path.remove(path.size() - 1);
        }
    }

    /**
     * DP 解法
     */
    public static int getResDP(int num) {
        String s = String.valueOf(num);
        int n = s.length();
        //1、dp[i] ：前i个数字不同的翻译方案数；求dp[n]
        int[] dp = new int[n + 1];

        //3.
        dp[0] = 1; //代入dp[2]求出
        dp[1] = 1;

        //2、
        // 第i个数字，本身可以自己翻译，那么就是有 dp[i-1];
        // 如果第i个数字和第i-1个数字，两个组合也可以成功翻译，那么就是有 dp[i-2] + dp[i-1]; 不可以成功，那就是dp[i-1]；
        for (int i = 2; i < dp.length; i++) {
            // i——前i个数字，当前数字的索引是i-1
            if (Integer.parseInt(s.substring(i - 2, i)) > 25 || s.charAt(i - 2) == '0') {
                //不满足
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 2] + dp[i - 1];
            }
        }
        System.out.println(dp[n]);
        return dp[n];
    }
}
