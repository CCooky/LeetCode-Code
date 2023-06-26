import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://leetcode.cn/problems/restore-ip-addresses/
 */
public class 复原IP地址 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        restoreIpAddresses(s);
    }

    /**
     * 二刷ACM
     */
    public static List<String> restoreIpAddresses(String s) {
        //分割问题
        backTracking(s,0);
        System.out.println(pathList);
        return pathList;
    }

    // 分割线-startIndex；此次分割的子串【startIndex，i】
    static List<String> path = new ArrayList<>();
    static List<String> pathList = new ArrayList<>();

    public static void backTracking(String s, int startIndex) {
        //stop
        if (path.size()==4 && startIndex == s.length()) {
            //处理一下
            StringBuilder stringBuilder = new StringBuilder();
            for (String p : path) {
                stringBuilder.append(p).append(".");
            }
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            pathList.add(stringBuilder.toString());
            return;
        }
        if (path.size()>4) return;
        //3.
        for (int i = startIndex; i < s.length(); i++) {
            String sub = s.substring(startIndex, i + 1);
            if (!isValid(sub)){
                continue;
            }
            //
            path.add(sub);
            backTracking(s,i+1);
            path.remove(path.size()-1);
        }
    }

    private static boolean isValid(String sub) {
        if (sub.length()>3) return false;
        if (sub.charAt(0)=='0'&& sub.length()>1) return false;
        int num = Integer.parseInt(sub);
        if (num>=0 && num<=255) return true;
        return false;
    }

}

class Solution6 {
    public List<String> restoreIpAddresses(String s) {
        // 注意提前判断s！=null，否则会有空指针
        List<String> pathList = new ArrayList<>();
        if (s == null) return pathList;
        List<String> path = new ArrayList<>();
        int startIndex = 0;
        backTracking(s, path, pathList, startIndex);
        return pathList;
    }

    //1.参数：List<String>--存的是每次切割规则出来的字符串集合；List<List<String>>--切割规则出来的字符串集合满足里面每个字符串都是回文的集合
    // 需要startIndex，因为是同一个数据集合里面，切割过的地方，不能重复切割，和组合问题也是保持一致的。
    public void backTracking(String s, List<String> path, List<String> pathList, int startIndex) {
        //2.stop.明确切割出来的字符串为【startIndex，i】，startIndex为切割线从0开始，切割线所在的元素可以拿
        if (startIndex == s.length()) {
            // 只能切割四段哦，
            if (path.size() != 4) return;
            // 第三步回溯搜索里面已经判断了每个字符串均符合条件
            StringBuilder stringBuilder = new StringBuilder();
            for (String s1 : path) {
                stringBuilder.append(s1).append(".");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            pathList.add(stringBuilder.toString());
            return;  //记得return掉，不再往下遍历树
        }
        if (path.size() > 4) return;

        //3.处理、递归、回溯
        // 注意切割过的位置，不能重复切割，所以，backtracking(s, i + 1); 传入下一层的起始位置为i + 1。
        for (int i = startIndex; i < s.length(); i++) {
            //判断不满足分割出来的字符串不满足合法性就不往下递归了，直接for横向遍历下一个
            if (!isValid(s, startIndex, i)) {
                continue;
            }
            path.add(s.substring(startIndex, i + 1)); //左闭右开的
            backTracking(s, path, pathList, i + 1);//递归要不要加1，下次分割时应该从下一个元素所以加1，寻找i+1为起始位置的子串
            path.remove(path.size() - 1);
        }
    }

    public boolean isValid(String s, int left, int right) {
        // （每个整数位于 0 到 255 之间组成，且不能含有前导 0），只能切割四段啊
        if (s.charAt(left) == '0' && right > left) return false;
        if (right - left + 1 > 3) return false;
        String substring = s.substring(left, right + 1);
        int num = Integer.parseInt(substring);
        if (num < 0 || num > 255) return false;
        return true;
    }
}