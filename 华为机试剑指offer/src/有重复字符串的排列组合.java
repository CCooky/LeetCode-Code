import java.util.*;

public class 有重复字符串的排列组合 {
    public static void main(String[] args) {

    }
}

class Solution77 {
    public String[] permutation(String S) {
        char[] chars = S.toCharArray();
        //1、去重第一步：排序
        Arrays.sort(chars);
        backTracking(chars);
        String[] res = new String[pathList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = pathList.get(i);
        }
        return res;
    }

    // 有重复元素，树层去重
    List<String> pathList = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    Set<Integer> set = new HashSet<>(); //使用过的索引就不能再使用了
    public void backTracking(char[] nums) {
        //2.stop
        if (path.length() == nums.length) {
            pathList.add(path.toString());
            return;
        }
        //3.回溯搜索。处理、递归、回溯
        for (int i = 0; i < nums.length; i++) {
            //2、树层去重条件
            if (i>0 && !set.contains(i-1) && nums[i]==nums[i-1] ){
                continue;
            }
            if (set.contains(i)) continue;
            path.append(nums[i]);
            set.add(i);
            backTracking(nums);
            set.remove(i);
            path.deleteCharAt(path.length() - 1);
        }
    }
}