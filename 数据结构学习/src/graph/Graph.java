package graph;

import com.sun.org.apache.bcel.internal.generic.INEG;

import java.util.ArrayDeque;
import java.util.Queue;

public class Graph {
    private int V; //顶点数量
    private int edge; //
    private Queue<Integer>[] adj; //邻接表（索引表示每一个节点）

    public Graph(int V){
        this.V = V;
        adj = new Queue[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayDeque<Integer>();
        }
//        for (Queue<Integer> queue : adj) {
//            queue = new ArrayDeque<Integer>();
//        }
    }
    //1、获取图中顶点数量
    public int getV(){
        return V;
    }
    //2、获取图中边的数量
    public int getEdge(){
        return edge;
    }
    //3、向图中添加一条边 v-w
    public void addEdge(int v, int w){
        adj[v].offer(w);
        adj[w].offer(v);
        edge++;
    }
    //4、获取和顶点v相邻的所有顶点
    public Queue<Integer> getAdjV(int v){
        return adj[v];
    }

}
