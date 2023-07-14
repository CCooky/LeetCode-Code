import java.util.ArrayList;
import java.util.List;

public class 所有路径110 {
    public static void main(String[] args) {
        int[][] graph = new int[][]{{1, 2}, {3}, {3}, {}};
        System.out.println(new 所有路径110().getRes(graph));
    }

    public List<List<Integer>> getRes(int[][] graph) {
        // graph：邻接表，这里为有向的，也就是不会往回遍历到之前节点
        dfs(0, graph);
        return pathList;
    }

    //dfs
    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> pathList = new ArrayList<>();

    public void dfs(int x, int[][] ver) {
        path.add(x); // 注意点1
        if (x == ver.length - 1) { //成功到达目标节点
            pathList.add(new ArrayList<>(path));
            path.remove(path.size() - 1); //注意点2
            return;
        }
        for (int y : ver[x]) {
            dfs(y, ver);
        }
        path.remove(path.size() - 1);
    }
}

/**
 * 更加好看的解法，和上面思路一样，但有一个地方需要理解清楚才可以，就是为什么dfs之前要先把出发节点入list，不先放入会怎么样
 */
class 所有路径110_2 {
    public List<List<Integer>> getRes(int[][] graph) {
        // graph：邻接表，这里为有向的，也就是不会往回遍历到之前节点
        path.add(0);
        dfs(0, graph);
        return pathList;
    }

    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> pathList = new ArrayList<>();
    //dfs
    public void dfs(int x, int[][] ver) {
        if (x == ver.length - 1) { //成功到达目标节点
            pathList.add(new ArrayList<>(path));
            return;
        }
        for (int y : ver[x]) { // 处理递归回溯，标准三样
            path.add(y);
            dfs(y, ver);
            path.remove(path.size() - 1);

        }
    }

}
