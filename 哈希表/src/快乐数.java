import java.util.HashSet;

/**
 * https://leetcode.cn/problems/happy-number/
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」 定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 *
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
public class 快乐数 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        boolean happy = solution3.isHappy(19);
        System.out.println(happy);
    }
}
class Solution3{
    /**
     * 很复杂的解法，最好不要进行这种数字、字符、字符串的转换，调用方法很费时间，也费空间
     */
    public HashSet<Integer> set = new HashSet<>();
    public boolean isHappy(int n){
        // 这里肯定是要转换成字符串数组的，每个单独拆分出来
        // 用到包装类的特有API，valueOf还有一个parse的
        if (!set.contains(n)){
            set.add(n);
        }else {
            return false;
        }
        if (n==1)  return true;
        String num = String.valueOf(n);
        char[] chars = num.toCharArray();
        int sum = 0;
        for (char aChar : chars) {
            sum += Integer.parseInt(String.valueOf(aChar))*Integer.parseInt(String.valueOf(aChar));
        }
        return isHappy(sum);

    }
    /**
     *  这道题有点难
     * 题目中说了会 无限循环，那么也就是说求和的过程中，sum会重复出现，这对解题很重要！
     * 就是说假如无线循环了，则为false返回，如果sum重复了就是false。如果sum有一次为1，则返回true。
     */
    public boolean isHappy2(int n) {
        //搞一个Set集合，利用哈希表重复的原理
        // 搞一个单独的方法吧，用来得到sum
        HashSet<Integer> hashSet = new HashSet<>();
        while (true){
            if (n==1) return true;
            if (hashSet.contains(n)) return false;
            else {
                hashSet.add(n);
                n = getNextNum(n);
            }
        }
    }
    public int getNextNum(int n){
        // %10操作,得到最后一位数，然后n/10，
        int sum=0;
        while (n>0){
            int temp = n%10;
            sum += temp*temp;
            n = n/10;
        }
        return sum;
    }
}


























