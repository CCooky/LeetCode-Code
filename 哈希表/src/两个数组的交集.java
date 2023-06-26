import java.util.ArrayList;
import java.util.HashSet;

/**
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。
 * 输出结果中的每个元素一定是唯一 的。我们可以 不考虑输出结果的顺序 。
 * 1 <= nums1.length, nums2.length <= 1000
 *
 * 输入：nums1 = [4,9,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 */
public class 两个数组的交集 {
    public static void main(String[] args) {
        int[] a = {};
        int[] b = {};
        b=null;
        System.out.println(a);
        System.out.println(b);  //编译错误：可能尚未初始化变量b
    }

}
class Solution1{
    public int[] intersection(int[] nums1, int[] nums2){
        // 如果有数组为空
        if (nums1==null || nums2==null) return null;
        HashSet<Integer> hashSet = new HashSet<>();
        HashSet<Integer> list = new HashSet<>();
        for(int ele: nums1){
            hashSet.add(ele);
        }
        for (int ele: nums2){
            if (hashSet.contains(ele)){
                list.add(ele);
            }
        }
        // 如果arraylist长度为0，则返回null
        if (list.size()==0) return null;
        int len = list.size();
        int[] res = new int[len];
        int i = 0;
        for (Integer ele: list){
            res[i++] = ele;
        }
        return res;
    }
}
