package UF;

import com.sun.org.apache.xml.internal.utils.SystemIDResolver;

import java.util.Scanner;

public class UFTest {
    public static void main(String[] args) {
//        UF_array uf = new UF_array(5);
//        UF_tree uf = new UF_tree(5);
        UF_tree_weight uf = new UF_tree_weight(5);

        System.out.println("  当前并查集中分组个数："+uf.count());
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("输入需要合并的元素p：");
            int p = sc.nextInt();
            System.out.print("输入需要合并的元素q：");
            int q = sc.nextInt();
            if (uf.connected(p,q)){
                System.out.println(p+"元素和"+q+"元素已经在同一个分组");
                continue;
            }
            uf.union(p, q);
            System.out.println("当前并查集中分组个数："+uf.count());
        }
    }
}
