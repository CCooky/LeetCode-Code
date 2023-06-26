/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */

/**
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2]
 * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
 * <p>
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,4,0,3]
 * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
 */

public class 移除元素 {
    public static void main(String[] args) {
//        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int[] nums = {2, 2, 2, 2, 2, 2, 2, 2};
        int val = 1;
        int i = leftRightRemoveElement2(nums, val);
        System.out.println();
        System.out.println(i);

    }

    // 思考：数组长度为n，如果重新申请新数组，则额外空间为O（n），不行，只能在原数组上操作
    // 我知道了，不用考虑顺序，只要保证前几个元素是我们要找的就行了
    // 那我们就直接采用交换就行了，把目标元素都扔到数组末尾、

    /**
     * 单移动双指针
     * 就是把等于val的元素全部移动到数组最后面不就行了嘛
     */
    // 定义左右两个指针，分别指向数组开始和末尾
    // 移动左指针，如果left的值等于val，则两个指针交换数据，右指针移动一位，左指针不动；（需要判断新来的值）
    // 如果不等于val，则左指针移动，接着找等于val的；
    // 循环条件为 （left<=right), 等于的时候要接着判断 (如[val,val,..],[noval,noval,...])
    public static int leftRightRemoveElement2(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        int temp;
        while (left <= right) {
            if (nums[left] == val) {  //等于value，则交换数据，右指针移动一位，但左指针不能动
                temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;
            } else {  // 不等于val，接着左指针移动
                left++;
            }
        }
        return left;
    }


    /**
     * 正确解法2：同移动双指针，重点找等于val的元素，用后面的元素覆盖
     */
    // 定义左右两个指针，分别指向数组开始和末尾
    // 然后移动左指针，到第一个等于val的元素位置；移动右指针，到第一个不等于val的元素位置。
    // 然后判断是否left < right（这种情况，left不可能等于right）,小于则需要交换，不小于则说明已经全部分好了，
    // [0,right]区间都是满足要求的元素，[left,length-1]都是等于val的元素.
    public static int leftRightRemoveElement(int[] nums, int val) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        int temp;
        while (true) {
            //1、移动左指针，到第一个等于val的元素位置
            while (left <= length - 1) {
                if (nums[left] == val) break;
                left++;
            }
            //2、移动右指针，到第一个不等于val的元素位置
            while (right >= 0) {
                if (nums[right] != val) break;
                right--;
            }
            // 3、先要判断是否left<=right,小于则需要交换，不小于则说明已经全部分好了，
            // [0,right]区间都是满足要求的元素，[left,length-1]都是等于val的元素
            if (left < right) {
                temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            } else break;
        }
        return left;  //返回的是新数组的元素个数
    }


    /**
     * 正确解法1：快慢指针，重点找到不等于val元素往前放
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    // 首先快、慢指针都指向元素的第一个位置，然后先移动快指针
    // 如果快指针指向的元素不等于val，它一定是输出数组的一个元素，我们就将快指针指向的元素复制到慢指针位置，然后将快、慢指针同时右移；
    // 如果快指针指向的元素等于 val，它不能在输出数组里，此时慢指针不动，快指针右移一位。
    // 整个过程保持不变的性质是：区间 [0,slow-1]中的元素都不等于val。
    // 当快指针遍历完输入数组以后，slow指针的值就是输出数组的长度。
    public static int fastSlowRemoveElement(int[] nums, int val) {
        int fast = 0;
        int slow = 0;
        int length = nums.length;
        while (fast < length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
                fast++;
            } else {
                fast++;
            }
        }
        return slow;
    }
}

class Solution100{
    // 输入：nums = [3,2,2,3], val = 3
    // 输出：2, nums = [2,2]
    public int removeEle(int[] nums, int val){
        if (nums.length==0) return 0;
        //就是把满足的元素全部移动到前面来即可，直接双指针
        //快慢指针：快指针找到一个就往满指针位置放
        int fast = 0;
        int slow = 0;
        int num = 0;
        while (fast<nums.length){
            if (nums[fast]!=val){ //ok
                nums[slow] = nums[fast];
                slow++;
                fast++;
                num++;
            }else {
                fast++;
            }
        }
        return num;
    }
}
