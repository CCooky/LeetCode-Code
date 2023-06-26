import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 */
public class 有效的字母异位词 {
}
class Solution{
    /**
     * 第一种：很简单，先变成字符数组，然后排序，再一个for循环挨个比较就行了。
     * 其中排序，用到了数组工具类，不然就要自己写排序算法
     */
    public boolean isAnagram(String s, String t){
        // s,t 为null时 & 两者长度不一样时
        if (s==null || t==null) return false;
        if (s.length()!=t.length()) return false;
        // 先转换成字符数组
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        // 使用数组根据类进行排序
        Arrays.sort(chars);
        Arrays.sort(chart);
        // 再一个个比较即可
        for (int i=0; i<chars.length;i++){
            if (chars[i]!=chart[i]) return false;
        }
        return true;
    }

    /**
     * 第二种罗：利用哈希表的原理
     * 数组其实就是一个简单哈希表，而且这道题目中字符串只有小写字符，
     * 那么就可以定义一个数组，来记录字符串s里字符出现的次数。
     * 先需要把字符映射到数组也就是哈希表的索引下标上，因为字符a到字符z的ASCII是26个连续的数值，
     * 所以字符a映射为下标0，相应的字符z映射为下标25。不需要再搞哈希函数了
     * 1、再遍历字符串s的时候，只需要将 (s[i] - ‘a’ )索引所在的元素做+1 操作即可，
     * 并不需要记住字符a的ASCII，只要求出一个相对数值就可以了。
     * 2、检查字符串t中是否出现了这些字符，同样在遍历字符串t的时候，
     * 对t中出现的字符映射哈希表索引上的数值再做-1的操作。
     * 最后如果record数组所有元素都为零0，说明字符串s和t是字母异位词，return true。
     */
    public boolean isAnagramHash(String s, String t){
        // s,t 为null时 & 两者长度不一样时
        if (s==null || t==null) return false;
        if (s.length()!=t.length()) return false;
        //
        int[] record = new int[26];  // 默认为0
        for (int i = 0; i<s.length();i++){
            record[s.charAt(i) - 'a']++;
        }
        for (int i =0; i<t.length();i++){
            record[t.charAt(i)-'a']--;
        }
        for (int  ele :record){
            if (ele != 0) return false;
        }
        return true;
    }
}
