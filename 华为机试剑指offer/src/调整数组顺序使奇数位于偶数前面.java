import java.util.Scanner;

public class 调整数组顺序使奇数位于偶数前面 {
    //输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
    //0 <= nums.length <= 50000
    //0 <= nums[i] <= 10000
    public static void main(String[] args) {
        System.out.println(0%2);
        System.out.println(-6%2!=0);
    }
}
class Solution19 {
    // 很简单，双指针即可，把所有的奇数移动到数组前面。采用单移动版本
    public int[] exchange(int[] nums) {
        if (nums.length==0) return nums;
        int fast = 0;
        int slow = 0;
        int temp;
        while (fast<= nums.length-1){
            if (isOdd(nums[fast])){
                temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                slow++;
                fast++;
            }else {
                fast++;
            }
        }
        return nums;
    }

    // 素数是一个大于1 的自然数
    public boolean isPrime(int n){
        if (n<2) return false; //均不是素数
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }

    // 奇数有正、负之分。一个不能被2整除的整数
    public boolean isOdd(int n){
        return n%2!=0;
    }
}
