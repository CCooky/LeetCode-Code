import java.util.ArrayList;
import java.util.List;

public class 和为s的连续正数序列 {
    public static void main(String[] args) {
        getRes(15);
    }

    public static int[][] getRes(int targert) {
        //查找的数据范围应该是【1，target/2 +1】,最大是target/2 +1
        int[] nums = new int[targert / 2 + 2];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        //
        List<List<Integer>> pathList = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int sum = 0; //窗口内元素的和
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            //i——结束位置
            sum +=nums[i];
            path.add(nums[i]);
            if (sum==targert){
                pathList.add(new ArrayList<>(path));
            }else if (sum > targert){
                //左指针移动到合理位置
                while (sum>targert){
                    sum -= nums[left];
                    path.remove(0);
                    left++;
                }
                //这里可能出现sum==targert情况，需要判断
                if (sum == targert){
                    pathList.add(new ArrayList<>(path));
                }
            }
        }
        //
        System.out.println(pathList);
        return null;



    }

}
