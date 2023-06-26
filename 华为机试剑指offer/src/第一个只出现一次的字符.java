public class 第一个只出现一次的字符 {
    public static void main(String[] args) {

    }
}
class Solution44{
    public char getResult(String s){
        if (s.equals("")) return ' ';
        //使用map统计字符出现的次数，由于这里已知了只会出现26个小写字母
        //所以可以使用数组做哈希表，降低复杂度
        int[] nums = new int[26]; // 'a'--0索引
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a'; //该字符的哈希表索引
            nums[index] ++;
        }
        // 注意哦，可能有多个字符均只出现一次，这里是找出第一个字符，还要有顺序我去。
        // 哦，那我们就再次遍历字符串，并且同时get出每个字符的频次判断即可
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a'; //该字符的哈希表索引
            if (nums[index] ==1) return s.charAt(i);
        }
        return ' '; //如果没有一个字符只出现一次
    }
}
