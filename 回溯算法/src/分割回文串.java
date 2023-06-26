import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。
 * 返回 s 所有可能的分割方案。
 * <p>
 * 回文串 是正着读和反着读都一样的字符串。
 */
public class 分割回文串 {
}

/**
 * 内存优化，和那个树层去重类似，假如我当前拿出来的不是回文串，那我就不往下递归了，直接for横向遍历下一个
 */
class Solution7 {
    public List<List<String>> partition(String s) {
        // 注意提前判断s！=null，否则会有空指针
        List<List<String>> pathList = new ArrayList<>();
        if (s == null) return pathList;
        List<String> path = new ArrayList<>();
        int startIndex = 0;
        backTracking(s, path, pathList, startIndex);
        return pathList;
    }

    //1.参数：List<String>--存的是每次切割规则出来的字符串集合；List<List<String>>--切割规则出来的字符串集合满足里面每个字符串都是回文的集合
    // 需要startIndex，因为是同一个数据集合里面，切割过的地方，不能重复切割，和组合问题也是保持一致的。
    public void backTracking(String s, List<String> path, List<List<String>> pathList, int startIndex) {
        //2.stop.明确切割出来的字符串为【startIndex，i】，startIndex为切割线从0开始，切割线所在的元素可以拿
        if (startIndex == s.length()) {
            pathList.add(new ArrayList<>(path)); //MD，没有new，写太多了忘记了
            return;  //记得return掉，不再往下遍历树
        }

        //3.处理、递归、回溯
        // 注意切割过的位置，不能重复切割，所以，backtracking(s, i + 1); 传入下一层的起始位置为i + 1。
        for (int i = startIndex; i < s.length(); i++) {
            if (!isPalindrome(s, startIndex, i)) {
                continue;//当前分割的不是回文串，不往下纵向遍历，直接跳过，for循环横向遍历下一个
            }
            path.add(s.substring(startIndex, i + 1)); //左闭右开的
            backTracking(s, path, pathList, i + 1);//递归要不要加1，下次分割时应该从下一个元素所以加1，寻找i+1为起始位置的子串
            path.remove(path.size() - 1);
        }
    }

    public boolean isPalindrome(String s, int left, int right) {
        while (left < right) { //==的时候也不需要判断
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

/**
 * 二刷
 */
class Solution7_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        partition(s);
    }

    public static List<List<String>> partition(String s) {
        backTracking(s,0);
        System.out.println(pathList);
        return pathList;

    }

    // 分割线-startIndex；此次分割出来的子串【start Index，i】
    static List<String> path = new ArrayList<>();
    static List<List<String>> pathList = new ArrayList<>();

    public static void backTracking(String s, int startIndex) {
        // stop
        if (startIndex == s.length()) {
            pathList.add(new ArrayList<>(path));
            return;
        }

        //3.
        for (int i = startIndex; i < s.length(); i++) {
            String sub = s.substring(startIndex, i + 1);
            if (!isPalinDrome(sub)) {
                continue;
            }
            //
            path.add(sub);
            backTracking(s, i + 1);
            path.remove(path.size() - 1);
        }

    }

    private static boolean isPalinDrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}