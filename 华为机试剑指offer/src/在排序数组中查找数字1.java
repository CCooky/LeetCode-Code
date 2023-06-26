public class 在排序数组中查找数字1 {
     public static void main(String[] args) {

     }
     public static int getRes(int[] nums, int target){
          //直接遍历
          int res = 0;
          for (int i = 0; i < nums.length; i++) {
               if (nums[i]==target){
                    res++;
                    i++;
                    while (i<nums.length && nums[i]==target ){
                         res++;
                         i++;
                    }
                    return res;
               }
          }
          return 0;
     }
}
