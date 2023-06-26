import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，
 * 请你在该数组中找出和为目标值 target 的那两个整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。
 * 但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * nums = [2,7,11,15], target = 9
 */
public class 两数之和 {
    public static void main(String[] args) {
        int[] nums = {-18,12,3,0};
        int target = -6;
        Solution4 solution4 = new Solution4();
        int[] ints = solution4.woSumMap(nums, target);
        System.out.println(Arrays.toString(ints));
    }

}
class Solution4{
    /**
     *Set哈希表版本
     */
    public int[] woSum(int[] nums, int target){
        // 这里说了，一定有解的，即两个数满足要求
        // 先对数组里面元素去重，hashSet
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num: nums){
            if (!hashSet.contains(num)){
                hashSet.add(num);
            }
        }
        //再用两次for循环,找到那两个数。有可能会出现2+2 = 4得情况啊，所以遍历时要全部过一遍
        int[] res2 = new int[2];
        for (Integer num:hashSet){
            for (Integer num2:hashSet){   //这里不对，O（NN）
                if (num+num2==target){
                    res2[0] = num;
                    res2[1] = num2;
                }
            }
        }
        // 上面得到是哪两个数，但答案要求返回索引(2+2=4???)
        // 只能先找第一个索引，找第二个索引时，要去掉第一个索引的检查
        int index1 = 0,index2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == res2[0]){
                index1 = i;
                break;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i==index1) continue;
            if (nums[i]==res2[1]){
                index2 = i;
                break;
            }
        }
        res2[0]=index1;
        res2[1] = index2;
        return res2;
    }
    /**
     * Map哈希表版本
     * 有人问了，不对啊，我要是找的数在数组的后面呢，这都是遍历的前面的数啊
     */
    public int[] woSumMap(int[] nums, int target){
        //如果数组元素小于2,直接返回空数组
        if (nums.length<2) return new int[0];
        //hashmap存储已经遍历过的数，键为数值，value为其数组索引
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<nums.length;i++){
            // 加法变减法，需要找的元素target-nums[i]
            int b = target-nums[i];
            if (map.containsKey(b)){ //如果包含，则找到了这两个数，返回各自的索引
                int[] res = new int[2];
                res[0] = i;
                res[1] = map.get(b);
                return res;
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
}

