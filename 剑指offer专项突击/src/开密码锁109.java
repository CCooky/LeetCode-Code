import java.util.*;

public class 开密码锁109 {
    //
    public int getRes(String[] deadends, String target) {
        // 最少次数只能用BFS，暴力搜索, 初始状态是0000,然后0000旋转一次得到的状态有限，我们放入队列依次判断（是否等于target，是否碰到死亡密码），如果没有就将每个状态的下一个所有旋转状态放入队列判断。并且记录旋转次数
        // 还要注意，因为我们的方向是无向的，所以要防止重复入队，否则会超时
        String start = "0000";
        Queue<String> queue = new ArrayDeque<>();
        queue.add(start);
        List<String> list = new ArrayList<>();
        Set<String> deadSet = new HashSet<>(); // 将死亡密码存入set集合中，快速判断死亡
        for (int i = 0; i < deadends.length; i++) {
            deadSet.add(deadends[i]);
        }
        Set<String> outdateSet = new HashSet<>(); // 存储已经判断过的密码状态
        // begin
        int step = 0;
        while (!queue.isEmpty()) {
            while (!queue.isEmpty()) { //判断当前层所有的情况
                String current = queue.poll();
                if (Objects.equals(current, target)) { //判断目标值
                    return step;
                }
                if (deadSet.contains(current)) { //判断死亡密码，这里将死亡密码存入set集合中
                    continue;
                }
                if (outdateSet.contains(current)) { // 防止重复入队
                    continue;
                } else outdateSet.add(current);
                list.add(current);
            }
            for (String s : list) { //将下一层的所有状态放入队列
                queue.addAll(getAllState(s));
            }
            list.clear();
            step++; // 记录旋转次数+1
        }
        return -1; //还有一种是无法开锁
    }


    // 某个锁状态，旋转一次后可能得到的所有状态
    private List<String> getAllState(String curState) {
        List<String> list = new ArrayList<>();
        int[] state = new int[]{1, -1};
        for (int i = 0; i < curState.length(); i++) { //i：此次旋转的数字索引
            Integer index = getIndexByCharMap.get(curState.charAt(i)); //根据当前旋转数字定位索引，然后就可以找到前一个后一个字符了
            for (int sta : state) {
                int new_index = index + sta;
                if (new_index == 10) new_index = 0;
                if (new_index == -1) new_index = 9;
                Character new_char = allChar.get(new_index);
                String new_string = curState.substring(0, i) + new_char + curState.substring(i + 1);
                list.add(new_string);
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
