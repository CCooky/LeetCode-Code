import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class n个骰子的点数 {
    public static void main(String[] args) {
        dicesProbability(2);
    }

    public static double[] dicesProbability(int n){
        //组合问题，组合n个数即可，求每个和有多少种组合，【23】【32】是两种哦，不同的集合去取，比较简单，不属于排列
        backTracking( n,0);
        int mapvalueSum = 0;
        mapvalueSum = (int)Math.pow(6,n);
        Set<Map.Entry<Integer,Integer>> entries = map.entrySet();
        double[] res = new double[map.size()];
        int i = 0;
        for (Map.Entry<Integer,Integer> entry: entries){
            // 这里我们求组合的时候，是按照从小大大来的，不用再排序了
            double v = (double) entry.getValue() / (double) mapvalueSum;
            v = Double.parseDouble(String.format("%.5f",v));
            res[i++] = v;
        }
        System.out.println(Arrays.toString(res));
        return res;
    }

    // index：切换不同数据集, 从0开始
    // map 存放每个可能出现的点数和，它出现的次数
    static Map<Integer,Integer> map = new HashMap<>();
    static int sum = 0;
    static int[] nums = new int[]{1,2,3,4,5,6};
    public static void backTracking(int n, int index){
        if (index == n){
            if (map.containsKey(sum)){
                map.put(sum, map.get(sum)+1);
            }else {
                map.put(sum,1);
            }
            return;
        }
        //
        for (int i = 0; i < nums.length ; i++) {
            sum += nums[i];
            backTracking(n,index+1);
            sum -= nums[i];
        }
    }
}
