import java.util.*;

public class 生成匹配的括号085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(new 生成匹配的括号085().getRes(n));
    }


    public List<String> getRes(int n) {
        //1.生成n个（和n个）的所有排列哦，不是组合
        List<String> allSymbol = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            allSymbol.add("(");
        }
        for (int i = 0; i < n; i++) {
            allSymbol.add(")");
        }
        Set<Integer> indexSet = new HashSet<>();
        backtracking(allSymbol, indexSet);
        System.out.println(pathList);
        //2.使用栈结构，判断所有组合是否合法
        Stack<String> stack = new Stack<>();
        List<String> ans = new ArrayList<>();
        for (List<String> stringList : pathList) {
            stack.clear();
            for (String s : stringList) {
                if (stack.isEmpty()) stack.push(s);
                else if (s.equals(")") && stack.peek().equals("(")) { // 判断即将入栈元素是否匹配栈顶元素
                    stack.pop();
                } else {
                    stack.push(s);
                }
            }
            if (stack.isEmpty()) { // 该组合满足要求
                StringBuilder stringBuilder = new StringBuilder();
                for (String s : stringList) {
                    stringBuilder.append(s);
                }
                ans.add(stringBuilder.toString());
            }
        }
        return ans;
    }

    // 求所有排列,注意有树层去重（结果去重）去重先排序相同的放在一起，回溯
    public List<List<String>> pathList = new ArrayList<>();
    public List<String> path = new ArrayList<>();

    public void backtracking(List<String> list, Set<Integer> indexSet) {
        // 2.stop
        if (path.size() == list.size()) {
            pathList.add(new ArrayList<>(path));
            return;
        }
        //3.回溯搜索（处理递归回溯）
        for (int i = 0; i < list.size(); i++) {
            if (indexSet.contains(i)) { //避免放入重复的元素
                continue;
            }
            if (i>0 && list.get(i).equals(list.get(i-1)) && !indexSet.contains(i-1)){
                continue;
            }
            path.add(list.get(i));
            indexSet.add(i);
            backtracking(list, indexSet);
            indexSet.remove(i);
            path.remove(path.size() - 1);
        }
    }
}
