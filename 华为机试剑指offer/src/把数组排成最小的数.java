import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 把数组排成最小的数 {
    public static void main(String[] args) {
        System.out.println("3".compareTo("30"));
    }

    //
    public String getResult(int[] nums){
        List<String> stringList = new ArrayList<>();
        for (int num : nums) {
            stringList.add(""+num);
        }
        // o1.compareTo(o2) 大于即正整数(o1 - o2)
        Collections.sort(stringList,((o1, o2) -> (o1+o2).compareTo(o2+o1)));
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : stringList) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}
