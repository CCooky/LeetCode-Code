package UF;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UF_tree {
    private int[] eleAndGroup;
    private int count;

    //初始化的规则：树的管理
    // 1.一共有N个元素，分别是0——N-1，为数组的索引
    // 2.数组存储该元素节点的父节点，如果节点值等于父节点，说明该节点是根节点了
    //初始化结果就是每个元素都是单独的根节点，0元素根节点为0，1元素根节点为1,.....
    public UF_tree(int N) {
        this.count = N;
        eleAndGroup = new int[N];
        for (int i = 0; i < eleAndGroup.length; i++) {
            eleAndGroup[i] = i;
        }
    }
    //1.获得当前并查集中有多分组，输出每个分组编号和组内元素
    public int count() {
        // key——分组的根节点，list——该分组的所有元素
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < eleAndGroup.length; i++) {
            if (i == eleAndGroup[i]) {
                //找到一个根节点
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j < eleAndGroup.length; j++) {
                    if(getGroupNum(j)==i) list.add(j);
                }
                hashMap.put(i, list);
            }
        }
        System.out.println(hashMap);
        return this.count;
    }
    //2. 判断元素p、q是否在同一个分组
    public boolean connected(int p, int q) {
        return getGroupNum(p) == getGroupNum(q);
    }
    //3.获取当前元素所在分组编号（这里是树的结构实现）
    public int getGroupNum(int ele) {
        //树的根节点处
        while (ele != eleAndGroup[ele]) {
            ele = eleAndGroup[ele];
        }
        return ele;
    }
    //4.将p、q元素所在分组进行合并，全部合并到p分组去
    // 这里我们只需要将q元素所在的根节点，它的父节点变成p元素的根节点即可
    public void union(int p, int q){
        int pGroupNum = getGroupNum(p);
        int qGroupNum = getGroupNum(q);
        eleAndGroup[qGroupNum] = pGroupNum;
        this.count--;
    }

}
