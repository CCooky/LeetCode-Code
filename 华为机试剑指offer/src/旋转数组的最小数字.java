public class 旋转数组的最小数字 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 2, 2, 2};
        Solution5 solution = new Solution5();
        System.out.println(solution.minArray(nums));
    }
}

class Solution5 {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        int mid = (left+right)/2;
        while (left!=right){ //当left==right时结束
            if (numbers[mid]>numbers[right]){
                //将mid和right进行比较，如果mid大于right，那么右边区间是异常的。left=mid+1
                left = mid+1;
                mid = (left+right)/2;
            }else if (numbers[mid]<numbers[right]){
                // 如果mid小于right，说明右边正常，左边肯定是正常的，因为数组最前面是升序的，不信你可以试试。right = mid;
                right = mid;
                mid = (left+right)/2;
            }else if (numbers[mid] == numbers[right]){
                // 如果mid等于right，那么无法判断 mmm 在哪个排序数组中， 执行 j=j−1j = j - 1j=j−1 缩小判断范围，分析见下文。
                right--;
                mid = (left+right)/2;
            }
        }
        return numbers[left];
    }
}
