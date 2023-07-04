import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 开密码锁109 {
    public static void main(String[] args) {
        List<String> allState = new 开密码锁109().getAllState("0000");
        System.out.println(allState);
    }
    //
    public int getRes(List<String> deadends, String target) {

        // 最少次数只能用BFS，暴力搜索, 初始状态是0000
        return 0;
    }


    // 某个锁状态，旋转一次后可能得到的所有状态
    public List<String> getAllState(String curState) {
        StringBuilder stringBuilder = new StringBuilder(curState);
        List<String> list = new ArrayList<>();
        int[] state = new int[]{1,-1};
        for (int i = 0; i < stringBuilder.length(); i++) {
            Integer index = getIndexByCharMap.get(stringBuilder.charAt(i));
            for (int sta : state) {
                int new_index = index + sta;
                if (new_index==10) new_index = 0;
                if (new_index==-1) new_index = 9;
                StringBuilder replace = stringBuilder.replace(i, i + 1, String.valueOf(new_index));
                list.add(replace.toString());
            }
        }
        return list;
    }


    // 每个密码的位置可能出现的状态
    private List<Character> allChar = new ArrayList<Character>() {{
        add('0');
        add('1');
        add('2');
        add('3');
        add('4');
        add('5');
        add('6');
        add('7');
        add('8');
        add('9');
    }};
    // 根据当前密码字符定位索引
    private Map<Character, Integer> getIndexByCharMap = new HashMap<Character, Integer>() {{
        put('0', 0);
        put('1', 1);
        put('2', 2);
        put('3', 3);
        put('4', 4);
        put('5', 5);
        put('6', 6);
        put('7', 7);
        put('8', 8);
        put('9', 9);
    }};
}
