import java.util.ArrayList;
import java.util.List;

public class 打印从1到最大的n位数 {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();

    }
}
class Solution25{
    public int[] getResult(int n){
        //2--两个9
        StringBuilder stringBuilder = new StringBuilder();//创建一个空字符串
        for (int i = 0; i < n; i++) {
            stringBuilder.append(9);
        }
        int Maxnum = Integer.parseInt(String.valueOf(stringBuilder));
        int[] nums = new  int[Maxnum];
        for (int i = 1; i <= Maxnum; i++) {
            nums[i-1]  = i;
        }
        return nums;
    }


}

