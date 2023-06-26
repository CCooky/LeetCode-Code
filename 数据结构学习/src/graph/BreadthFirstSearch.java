package graph;

import java.util.*;

public class BreadthFirstSearch {
    private boolean[] marked;
    private int count;
    private Queue<Integer> queue; //层序遍历辅助
    public List<Integer> ans = new ArrayList<>();

    //使用广度优先搜索找出G图中s顶点的所有相邻顶点
    public BreadthFirstSearch(Graph G, int s) {
        this.marked = new boolean[G.getV()];
        this.count = 0;
        this.queue = new ArrayDeque<>();
        bfs(G, s);
    }

    //1、bfs
    public void bfs(Graph G, int s) {
        queue.offer(s);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            while (!queue.isEmpty()) {
                Integer poll = queue.poll();
                list.add(poll);
                count++;
                ans.add(poll);
            }
            for (Integer e : list) {
                marked[e] = true; //需要两个地方都来一次true
                for (Integer w : G.getAdjV(e)) {
                    //遍历每个节点的邻接表
                    if (marked[w]) continue;
                    queue.add(w);
                    marked[w] = true; //需要两个地方都来一次true，因为子节点可能重复被添加
                }
            }
            list.clear();
        }
    }

    //2、判断w顶点与s顶点是否相通
    public boolean marked(int w){
        return marked[w];
    }

    //3、获取与顶点s相通的所有顶点的总数
    public int getCount(){
        return count;
    }


}
