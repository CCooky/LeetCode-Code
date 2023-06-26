import java.lang.reflect.Array;
import java.util.*;

/**
 * 给定一个整数数组 nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 */
public class 划分为k个相等的子集 {
    public static void main(String[] args) {
//        int[] nums = {1,1,1,1,2,2,2,2};
//        int k = 4;
//        int[] nums = {1,2,3,5};
//        int k = 2;
//        int[] nums = {4, 5, 9, 3, 10, 2, 10, 7, 10, 8, 5, 9, 4, 6, 4, 9};
//        int k = 5;
//        Solution18 solution18 = new Solution18();
//        System.out.println(solution18.canPartitionKSubsets(nums, k));
//        System.out.println(solution18.pathList);

        int[] nums = {4, 5, 9, 3, 10, 2, 10, 7, 10, 8, 5, 9, 4, 6, 4, 9};
        int k = 5;
        Solution19 solution19 = new Solution19();
        System.out.println(solution19.canPartitionKSubsets(nums, k));

    }
}

class Solution19 {
    /**
     * 带有返回值的回溯算法
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int index = 0;
        int[] bucketSum = new int[k];
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        int bucketSumTarget = sum / k;
        Map<Integer,List<Integer>> bucket = new HashMap<>();
        //bucket：记录每个桶内的球,要提前初始化
        for (int i = 0; i < k; i++) {
            List<Integer> list = new ArrayList<>();
            bucket.put(i,list);
        }
        /**
         * 代码超时了，
         * 优化1：我们从大到小排序，先让值大的元素选择桶，这样可以增加剪枝的命中率，从而降低回溯的概率
         */
        Arrays.sort(nums);
        int left = 0, right= nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }

        boolean result = backTracking(nums, k, index, bucketSum, bucketSumTarget, bucket);
        System.out.println(bucket);
        return result;
    }

    /**
     * @param nums：每个球的数值/重量
     * @param k：桶的个数
     * @param index:                     索引为 index的球开始做选择
     * @param bucketSum                  :每个桶内球总和，一共有k个桶，int[k]
     * @param bucketSumTarget：每个桶内总和的目标值
     * @param bucket：记录每个桶内的球            Map<Integer,List<Integer>>, 要提前初始化
     * @return
     */

    //1. 递归回溯的参数返回值；光是回溯类型的没有返回值这一说哦
    // 函数意义：当前索引index的球能否放入桶中？
    public boolean backTracking(int[] nums, int k, int index, int[] bucketSum, int bucketSumTarget, Map<Integer, List<Integer>> bucket) {

        //2.终止条件; 如果所有的球都做了选择就要停止了，即到了叶子节点
        if (index == nums.length) {  // 这是到了第n+1个球，说明前面n个球都选择了
            /**
             * 其实这个地方不需要判断直接返回true就行，
             * 因为当 index == num.length 时，所有球已经按要求装入所有桶，所以肯定是一个满足要求的解每个桶内球的和一定为 target
             * 但是这里时间复杂度很短，因为就一个 O（k），而且k很小一般，所以不优化也没啥
             */
            //然后判断每个桶内总和是不是满足要求。因为函数只是判断了该球能不能放进去某个桶哦
            for (int i = 0; i < k; i++) {
                if (bucketSum[i] != bucketSumTarget) return false;
            }
            return true;
        }

        //3. 单层递归逻辑，回溯逻辑
        // index的球做选择，放入哪个桶
        for (int i = 0; i < k; i++) {
            /**
             * 终极优化点2！！！！！！！！！！
             * 如果当前桶和上一个桶的总和相同，那么则跳过；因为如果这个index号球在上一个桶放进去的方案如果不行，那么在这个总和相同的桶方案肯定也不行啊
             * 和 排列/组合/子集 问题 中「元素可重不可复选」情况下「子集」的处理情况很相似！！！
             */
            if (i > 0 && bucketSum[i] == bucketSum[i - 1]) {
                continue;
            }
            // 剪枝：放入球后超过 target 的值，选择一下桶
            if (bucketSum[i] + nums[index] > bucketSumTarget) {
                continue;
            }
            // 处理：不超过，则该index球放入 i 号桶
            bucketSum[i] += nums[index];
            bucket.get(i).add(nums[index]);
            // 递归：处理下一个球 index+1
            if (backTracking(nums, k, index + 1, bucketSum, bucketSumTarget, bucket)) {
                return true; // 如果后面的球都可以放下，那么返回true，终止
            }
            //回溯：当前index球放入 i 号桶后，不符合要求
            bucketSum[i] -= nums[index];
            bucket.get(i).remove(bucket.get(i).size() - 1);
        }

        // k 个桶都不满足要求时
        return false;
    }
}

class Solution18 {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int Sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        int subSum = Sum / k;
        int startIndex = 0;
        /**
         * 一定要加排序的，从大到小排序才行，先取大的数值再取小的，否则出现什么啊,就是下面这种
         * int[] nums = {1,1,1,1,2,2,2,2};int k = 4;
         * 输出:  false;  [[1, 1, 1], [1, 2]]
         */
        Integer[] numss = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numss[i] = nums[i];
        }
        Arrays.sort(numss, (o1, o2) -> o2 - o1);
        System.out.println(Arrays.toString(numss)
        );
        backTracking(numss, subSum, startIndex);


        /**
         * 是否分割的子集用到了所有的元素;set里面记录了使用过的索引
         * //int[] nums = {1,2,3,5};int k = 2;
         * 输出【5】、【2，3】
         */
        if (set.size() != nums.length) {
            return false;
        }
        if (pathList.size() != k) {
            return false;
        }
        return true;
    }

    //回溯暴力，组合，并且带有分割的意思，其实是属于分割的类型吧; 最关键的就是如何让已经选取过的满足要求的子集元素，在下次找子集的时候不被使用
    //1.回溯参数，【1，2】和【2，1】是一样的要startIndex，并且每个元素只能用一次 i+1
    int sum = 0;
    List<Integer> path = new ArrayList<>();
    List<Integer> indexPath = new ArrayList<>();
    List<List<Integer>> pathList = new ArrayList<>();
    Set<Integer> set = new HashSet<>();

    public void backTracking(Integer[] nums, int subSum, int startIndex) {

        //2.终止条件
        if (sum == subSum) { //找到一个满足的子集,只要找到 k-1个子集即可，
            pathList.add(new ArrayList<>(path));
            // 标记子集内的元素，后面不可以再使用了,使用set标记索引。但是这里我们没有存索引，如何快速知道元素的索引呢，而且元素是有重复数值的
            // 所以我们在递归回溯的时候进行记录,不对，我们应该在这里进行统一标记，因为在for里面会有回溯过程
            // 我知道了，再使用一个path的List，记录这条路径的索引；使用一个map集合，也是可以的使用lambda表达式遍历
            set.addAll(indexPath);
            // 这里sum 全局变量要清空为0了，为什么！！想清楚，因为我这个子集已经单独拿出去了，sum按照回溯的规则只会清除上一个元素的值
            // sum = 0;也不对，因为我们回溯过程是一步步判断，当到了这一步时，我们应该直接回到根节点才行，不然他会利用前面集合的sum信息
            return;
        }
        if (sum > subSum) {
            return;
        }

        //3.
        for (int i = startIndex; i < nums.length; i++) {
            //争对已经被选取过的子集，元素不能再使用了，set
            if (set.contains(i)) {
                continue;
            }

//            // 这一步是，当我找到了一个子集后，应该一路回溯到根节点，中间不要再接着递归了
            boolean flag = false;
            for (Integer index : indexPath) {
                if (set.contains(index)) {
                    flag = true;
                    break;
                }
            }
            if (flag) continue;

            //处理
            sum = sum + nums[i];
            path.add(nums[i]);
            indexPath.add(i);
            //递归
            backTracking(nums, subSum, i + 1);
            //回溯
            sum = sum - nums[i];
            path.remove(path.size() - 1);
            indexPath.remove(indexPath.size() - 1);

        }
    }
}
