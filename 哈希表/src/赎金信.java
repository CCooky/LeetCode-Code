/**
 * 给你两个字符串：ransomNote 和 magazine ，由小写英文字母组成
 * 判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 */
public class 赎金信 {
}
class Solution7{
    /**
     * 很简单啊，因为都是小写已经知道元素有哪些，就是统计出现的元素以及各个元素出现的次数
     * 很明显，数组实现哈希表即可。
     * 第一个字符串，数组--，第二个数组++，看最后数组元素是否全部大于等于0，满足则为true
     */
    public boolean canConstruct(String ransomNote, String magazine){
        //1.如果ransomNote长度大于第二个，肯定无法构成，因为每个字符只能用一次
        if (ransomNote.length()>magazine.length()){
            return false;
        }
        //26个字母。'a'--索引0，依次类推（其实就是key-value类似的，只是key我们手动指定，就像map）
        int[] nums = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            nums[c-'a']--; //char计算规则，能算则算不能算就在一起
        }
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            nums[c-'a']++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<0){
                return false;
            }
        }
        return true;
    }
}
