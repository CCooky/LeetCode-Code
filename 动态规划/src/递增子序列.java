import javax.xml.xpath.XPath;
import java.util.*;

/**
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。
 * 你可以按 任意顺序 返回答案。
 *
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 */
public class 递增子序列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[]{4,4,6,7,7};
        backTracking(nums,0);
        System.out.println(pathList);
    }
    // 有树层去重，but不能排序！！ 根据题意，依然是组合形式
    // 可排序我们使用：i>startIndex && nums[i]==nums[i-1](每一层）
    // 这里也是针对每一层，那我们可以使用Set，set存从当前startIndex开始的部分，所以每一个for前面都要一个新的Set
    public static List<List<Integer>> pathList = new ArrayList<>();
    public static List<Integer> path = new ArrayList<>();
    public static void backTracking(int[] nums, int startIndex){
        //2.stop
        if (path.size()>=2){
            pathList.add(new ArrayList<>(path));
//            return; 接着找，
        }
        if (startIndex == nums.length) return;

        //3.回溯搜索（处理-递归-回溯）
        Set<Integer> set = new HashSet<>(); //存的是数值
        for (int i = startIndex; i < nums.length; i++) {
            if (path.size()!=0 && path.get(path.size()-1)>nums[i]){
                continue; //剪枝
            }
            if (set.contains(nums[i])){
                continue;
            }
            path.add(nums[i]);
            set.add(nums[i]); //和排列、组合问题去重不一样，这不需要回溯set
            backTracking(nums, i+1);
//            set.remove(nums[i]);
            path.remove(path.size()-1);
        }
    }
}
class Solution31 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        //输入的简单判断
        List<List<Integer>> pathList = new ArrayList<>();
        if (nums.length<2) return pathList;
        List<Integer> path = new ArrayList<>();
        int startIndex = 0;
        backTracking(nums,path,pathList,startIndex);
        return pathList;
    }
    //回溯，组合问题，需要树层去重，但是不能先对数据集合进行排序。使用set进去数值去重！
    // 1.参数；需要startIndex进行组合的去重（【12】【21】），每个元素使用一次i+1
//    Set<Integer> set = new HashSet<>();
    public void backTracking(int[] nums, List<Integer> path, List<List<Integer>> pathList, int startIndex){
        //2.终止条件。这里组合长度大于等于2，非严格递增（在回溯搜索里面判断）
        if (path.size()>=2){
            pathList.add(new ArrayList<>(path));
        }
        //3.回溯搜索；处理、递归、回溯
        Set<Integer> set = new HashSet<>();  // 定义在内部，每个树层的for循环开始前都有一个自己的空Set
        for (int i = startIndex; i < nums.length ; i++) {
            // 做树层去重的判断
            if (set.contains(nums[i])){
                continue;
            }
            // 做非严格递增的判断,如果比path里面最后一个元素大，就不是递增的. 注意path要不为空的哦！！！
            if ( path.size()!=0 && nums[i]<path.get(path.size()-1)){
                continue;
            }
            path.add(nums[i]);
            set.add(nums[i]);
            backTracking(nums, path, pathList, i+1);
//            set.remove(nums[i]); //不remove
            path.remove(path.size()-1);
        }
    }
}
