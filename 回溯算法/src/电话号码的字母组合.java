import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 0 <= digits.length <= 4
 */
public class 电话号码的字母组合 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.letterCombinations("23");
    }
}

class Solution2 {
    public List<String> letterCombinations(String digits) {
        List<String> pathList = new ArrayList<>();
        if (digits.length()==0){
            return pathList;
        }
        // 字符串中字符个数表示 要求组合的元素个数Num
        // 组合元素的数据集为：是分开的，2-对于三个元素，3-对于三个元素，不能本字符元素内部搭配,
        //怎么表示数据集,数字字母如何映射？使用map集合来映射可以，键值对啊
        Map<Character, String> phoneString = new HashMap<>();
        phoneString.put('2', "abc");
        phoneString.put('3', "def");
        phoneString.put('4', "ghi");
        phoneString.put('5', "jkl");
        phoneString.put('6', "mno");
        phoneString.put('7', "pqrs");
        phoneString.put('8', "tuv");
        phoneString.put('9', "wxyz");
        StringBuilder path = new StringBuilder();
        int startIndex = 0;
        backTracking(path, pathList, phoneString, digits, startIndex);
        return pathList;

    }

    //组合问题——暴力回溯
    //1.确定回溯函数参数。
    // 第一个存储满足要求组合结果的集合，第二个是满足要求的单一组合（路径）; 要求组合的元素个数Num.startIndex:表示我取的字符串里面第几个位置字符
    public void backTracking(StringBuilder path, List<String> pathList, Map<Character, String> phoneString, String digits, int startIndex) {
        //2.
        if (path.length() == digits.length()) {
            pathList.add(path.toString()); //存进去的是新对象
            return;
        }
        //3.这里比较难，我想想，处理、递归、回溯。首先要取出要操作的第一个数据集
        char key = digits.charAt(startIndex);
        String s = phoneString.get(key);
        for (int i = 0; i < s.length(); i++) {
            path.append(s.charAt(i));
            backTracking(path, pathList, phoneString, digits, startIndex +1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
