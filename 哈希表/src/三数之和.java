import java.util.*;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
 * 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。
 * 请你返回所有和为 0 且不重复的三元组。
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 */
public class 三数之和 {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(3);
        System.out.println(list1.equals(list2));
        System.out.println(list1.hashCode());
        System.out.println(list2.hashCode());
        HashSet<List<Integer>> set = new HashSet<>();
        set.add(list1);
        set.add(list2);
        System.out.println(set);

        int[] nums = {1, 2, -2, -1};
        Solution5 solution5 = new Solution5();
        solution5.threeSum(nums);
    }
}

class Solution5 {
    /**
     * 476 ms，几乎超时
     * 同两数之和，先用两个for确定两个数，然后使用hashset求第三个数，
     * 直接返回具体数值就行，不需要获得该数值额外信息，所以不需要使用map
     * 把符合条件的三元组放进List中，然后再去重，这样是非常费时的，很容易超时，
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // 假如最后需要返回索引的话，这个排序就不行了哦
        Arrays.sort(nums);

        //1.数组长度小于3
        if (nums.length < 3) return new ArrayList<List<Integer>>();
        //2.
        HashSet<Integer> hashSet = new HashSet<>(); // 找第三个元素
        List<List<Integer>> resList = new ArrayList<>(); // 返回结果对象
        //把符合条件的三元组放进List中，然后再去重，这样是非常费时的，很容易超时，
        HashSet<List<Integer>> set = new HashSet<>(); // 放入结果对象之前去重，先把满足要求的放这里
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // 还是这里问题啊，我往set添加后，就不能再用这个nums[i]了撒
                int temp = -nums[i] - nums[j];
                if (hashSet.contains(temp)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(temp);
//                  Collections.sort(list); //要返回索引的话，就只能在这里对三个数排序，时间复杂度会更高
                    set.add(list);
                }
            }
            hashSet.add(nums[i]);
        }
        //3. 对集合里面的list要去重，就是判断是否三个元素都相同
        // 用set集合不就行了嘛,不对list里面元素顺序不同两个对象也是不同的呀！！！
        // 哦，那我们吧List<Integer>排序不就行了吗，我草
        for (List<Integer> list : set) {
            resList.add(list);
        }
        return resList;
    }
}
