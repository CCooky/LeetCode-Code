package graph;

public class GraphTest {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        System.out.println(graph.getV());
        System.out.println(graph.getEdge());
        graph.addEdge(1,3);
        graph.addEdge(1,2);
        graph.addEdge(0,3);
        System.out.println(graph.getEdge());
    }
}
