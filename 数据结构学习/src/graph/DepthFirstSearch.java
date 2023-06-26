package graph;

import java.util.Queue;

// 使用深度优先搜索找出与s顶点所有相通顶点
public class DepthFirstSearch {
    private boolean[] marked; //索引代表顶点，表示当前顶点是否被搜索过了
    private int count; //记录有多少个顶点和s相通

    public DepthFirstSearch(Graph G, int s) {
        this.marked = new boolean[G.getV()];
        this.count = 0;
        dfs(G, s);
    }

    //1、使用dfs找出与s顶点所有相通顶点
    private void dfs(Graph G, int s) {
        // 先把s顶点标识为已经被搜索
        marked[s] = true;
        // 遍历邻接表
        Queue<Integer> adjV = G.getAdjV(s);
        for (Integer w : adjV) {
            //判断w顶点是否被搜索过
            if (!marked[w]) {
                dfs(G, w);
            }
        }
        //相通顶点数量+1
        count++;
    }
    //2、判断w顶点与s是否相通
    public boolean marked(int w){
        return marked[w]; //true-相通
    }
    //3、获取与顶点s相通的所有顶点数
    public int getCount(){
        return count;
    }
}
