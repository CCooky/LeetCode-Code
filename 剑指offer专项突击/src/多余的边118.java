import java.util.Arrays;

public class 多余的边118 {
    public static void main(String[] args) {
        int[][] edges = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        System.out.println(Arrays.toString(new 多余的边118().findRedundantConnection(edges)));
    }

    public int[] findRedundantConnection(int[][] edges) {
        UF uf = new UF();
        int[] ans = new int[2];
        for (int[] edge : edges) { // 判断每一条边
            int i = edge[0];
            int u = edge[1];
            if (uf.isConnect(i, u)) { // 如果该边两个节点已经在并查集中
                ans = edge;
            } else { // 不在，则将该边加入到并查集
                uf.union(i, u);
            }
        }
        System.out.println(Arrays.toString(uf.eleFather));
        return ans;
    }

}

class UF {
    public int[] eleFather;

    public UF() {
        eleFather = new int[6]; // 题目说了最多1000个节点，索引代表每个节点的编号
        for (int i = 0; i < eleFather.length; i++) {
            eleFather[i] = i;
        }
    }

    // 将 v->u v节点加入到u所在并查集中,这个看题目给的那端是根节点
    // 哇！！！那所有节点都直接连在同一个节点上了啊，最后发现就是这样的，完全没了输入的树结构
    public void union(int u, int v) {
        int uroot = find(u);
        int vroot = find(v);
        eleFather[vroot] = uroot;
    }

    // 找出元素的根节点（该并查集的头）
    public int find(int ele) {
        if (ele == eleFather[ele]) {
            return ele;
        }
        return find(eleFather[ele]);
    }

    // 判断两个元素是否在并查集中
    public boolean isConnect(int i, int u) {
        int iroot = find(i);
        int uroot = find(u);
        return iroot == uroot;
    }
}
