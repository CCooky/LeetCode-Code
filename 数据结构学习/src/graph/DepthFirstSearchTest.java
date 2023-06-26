package graph;

public class DepthFirstSearchTest {
    public static void main(String[] args) {
        //准备一个Graph对象
        Graph G = new Graph(13);
        G.addEdge(0,5);
        G.addEdge(0,1);
        G.addEdge(0,2);
        G.addEdge(0,6);
        G.addEdge(5,3);
        G.addEdge(5,4);
        G.addEdge(3,4);
        G.addEdge(6,4);

        G.addEdge(7,8);

        G.addEdge(9,11);
        G.addEdge(9,10);
        G.addEdge(9,12);
        G.addEdge(11,12);
        //准备dfs对象
        DepthFirstSearch search = new DepthFirstSearch(G,0);
        //测试与某个顶点相通的顶点数量
        System.out.println(search.getCount());
        //测试某个顶点与起点是否相通
        System.out.println(search.marked(5));
        System.out.println(search.marked(7));
    }
}
