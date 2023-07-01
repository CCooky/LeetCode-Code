public class 旋转数组的最小数字 {

    public int getRes(int[] numbers) {
        // 首先这里数组元素会有重复的的，会稍微复杂一点点
        // 本质上就是两段升序数组拼凑起来，找最小值；我们可以使用二分法。
        int left = 0;
        int right = numbers.length - 1;
        int mid = left + (right - left) / 2; //防止数值溢出
        while (left < right) {
            if (numbers[mid] > numbers[right]){
                // 说明，mid以及它的左边部分肯定是递增的，下一次搜索应该是【mid+1，right】肯定不包括mid这个点的，因为我们找的是最小值
                left = mid+1;
                mid = left + (right - left) / 2;
            } else if (numbers[mid] < numbers[right]) {
                // 说明，mid以及它右边的部分是递增的，包括mid在里面，那是不是也可能这个mid点就是最小值，所以下一次搜索区间应该是【left，mid】
                right = mid;
                mid = left + (right - left) / 2;
            }else {
                // 这里是重复元素的情况，比较复杂。我们可以简单理解为一段上升+一段平行，此时最小值是左边还是右边就无法确定了，方法就是缩小区间，去掉right值的判断
                // 因为我们知道mid=right的值，假如这个相等的值就是最小的，那也不影响，因为我们去掉right值的区间有最小值
                right--;
                mid = left + (right - left) / 2;
            }
        }
        return numbers[mid];
    }
}
