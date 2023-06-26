import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;

import java.util.*;

public class 字符串的排列 {
    public static void main(String[] args) {
        String s = "sluvys";
        Solution35 solution35 = new Solution35();
        solution35.getResult(s);
        System.out.println(solution35.pathList.size());
    }
}

class Solution35 {
    // 排列的树层去重版本。使用Set防止元素重复使用。第一步排序
    // 树层去重：i>0 && nums[i]==nums[i-1] && !set.contain(i-1)
    public String[] getResult(String s){
        //去重第一步排序啊我草
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        s = String.valueOf(chars);
        backTracking(s);
        String[] res = new String[pathList.size()];
        for (int i = 0; i < pathList.size(); i++) {
            res[i] = pathList.get(i);
        }
        return res;
    }

    //回溯
    StringBuilder path = new StringBuilder();
    List<String> pathList = new ArrayList<>();
    Set<Integer> usedIndex = new HashSet<>();
    public void backTracking(String s){
        //终止条件
        if (path.length()==s.length()){
            pathList.add(path.toString());
            return;
        }
        // 回溯搜索
        for (int i = 0; i < s.length(); i++) {
            // 防止同一个元素重复使用
            if (usedIndex.contains(i)){
                continue;
            }
            // 进行树层去重（元素索引不同，但数值相同）
            if (i>0 && s.charAt(i)==s.charAt(i-1)
                    && !usedIndex.contains(i-1)){
                continue;
            }
            //
            path.append(s.charAt(i));
            usedIndex.add(i);
            backTracking(s);
            usedIndex.remove(i);
            path.deleteCharAt(path.length()-1);
        }

    }
}
