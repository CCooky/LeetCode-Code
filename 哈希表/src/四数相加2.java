import java.util.HashMap;
import java.util.HashSet;

/**
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n
 * 请你计算有多少个元组 (i, j, k, l) 能满足：
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 *
 * 输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
 * 输出：2
 * 解释：
 * 两个元组如下：
 * 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
 */
public class 四数相加2 {

}
class Solution6{
    /**
     * 分析：这种肯定是一个个确定对吧，暴力四个for，用hash就是三个for
     * 运行结果：超时了
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4){
        //1.四个数组有一个为空则返回0
        if (nums1.length==0 || nums2.length==0 ||nums3.length==0 || nums4.length==0 ){
            return 0;
        }
        //2.三个for+hash
        HashMap<Integer,Integer> map = new HashMap<>();
        // 直接把第四个数组放到hashSet里面去。。。。。 这里不对哦，不能去重哦，会导致最后的元组个数少，因为这里是得到所有的组合，【1，1】的话就是两个都可以
        // 完了使用map也不行，好难啊，
        // 哦，可以哦，我们map的key是数组四的元素，value是该元素的出现次数
        for (int value : nums4) {
            if (!map.containsKey(value)) {
                map.put(value, 1);  // 不包含，则只出现了一次
            } else { //包含说明出现多次
                map.put(value, map.get(value) + 1);
            }
        }
        int resNum = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                for (int k = 0; k < nums3.length; k++) {
                    // 目标元素
                    int temp = -nums1[i]-nums2[j]-nums3[k];
                    // 如果包含则找到了
                    if (map.containsKey(temp)){
                        Integer n = map.get(temp);
                        resNum = resNum + n;
                    }
                }
            }
        }
        return resNum;
    }

    /**
     * 三个for就会超时了，很烦，那就分组两个for
     * 巧法解析：那我们把四个数组，分为两组呢，ab一组求出他们的和有多少种，cd一组求出他们的和有多少种
     * 然后两组和进行遍历，看满足要求的有多少种，WAWAWAWAWA
     * 这道题是什么，是他不需要知道是哪些元素加起来满足，是只要什么啊，只要知道有多少种可能就行了呀，
     *
     * 首先定义 一个map，key放a和b两数之和，value 放a和b两数之和出现的次数。
     * 遍历大A和大B数组，统计两个数组元素之和，和出现的次数，放到map中。
     * 定义int变量count，用来统计 a+b+c+d = 0 出现的次数。
     * 在遍历大C和大D数组，找到如果 0-(c+d) 在map中出现过的话，就用count把map中key对应的value也就是出现次数统计出来。
     * 最后返回统计值 count 就可以了
     */
    public int fourSumCount2(int[] nums1, int[] nums2, int[] nums3, int[] nums4){
        //1.四个数组有一个为空则返回0
        if (nums1.length==0 || nums2.length==0 ||nums3.length==0 || nums4.length==0 ){
            return 0;
        }
        //2.前两个为一组, 将a、b的和作为键，出现次数作为value
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                int key = i+j;
                if (!map.containsKey(key)){
                    map.put(key,1);
                }else {
                    map.put(key, map.get(key)+1);
                }
            }
        }
        //3. 看后面两个数组为一组，看map集合中是否有-(c+d)的元素，有的话则满足题目要求的和找到了，并且个数为value值
        int resSum = 0;
        for (int i : nums3) {
            for (int j : nums4) {
                if (map.containsKey(-i-j)){
                    resSum = resSum + map.get(-i-j);
                }
            }
        }
        return resSum;
    }
}
