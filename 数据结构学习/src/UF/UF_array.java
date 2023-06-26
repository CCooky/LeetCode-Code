package UF;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class UF_array {
    private int[] eleAndGroup; //每个元素和它的分组
    private int count; //该并查集中分组个数

    //初始化的规则：
    // 1.一共有N个元素，分别是0——N-1，为数组的索引
    // 2.最初每个元素各自单独一组，即共有N个分组，数组存储数值；
    //初始化结果就是，0元素在0号分组，1元素在1号分组,.....
    public UF_array(int N){
        this.count = N;
        eleAndGroup = new int[N];
        for (int i = 0; i < eleAndGroup.length; i++) {
            eleAndGroup[i] = i;
        }
    }
    //1.获得当前并查集中有多分组，输出每个分组编号和组内元素
    public int count(){
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < eleAndGroup.length; i++) {
            int groupNum = eleAndGroup[i];
            if (hashMap.containsKey(groupNum)){
                hashMap.get(groupNum).add(i);
            }else { //匿名内部类写法
                int finalI = i;
                hashMap.put(groupNum, new ArrayList<Integer>(){
                    {
                        add(finalI);
                    }
                });
            }
        }
        System.out.print(hashMap);
        return this.count;
    }
    //2. 判断元素p、q是否在同一个分组
    public boolean connected(int p, int q){
        return eleAndGroup[p]==eleAndGroup[q];
    }
    //3.获取当前元素所在分组编号（这里是非树的结构实现）
    public int getGroupNum(int ele){
        return eleAndGroup[ele];
    }
    //4.将p、q元素所在分组进行合并，全部合并到p分组去
    public void union(int p, int q){
        if (connected(p,q)) return;
        int pGroup = eleAndGroup[p];
        // 遍历数组，将q分组所有元素变成p分组去
        int qgroup = eleAndGroup[q];
        for (int i = 0; i < eleAndGroup.length; i++) { //这里是用数组实现的弊端，将所有元素合并需要O（N^2）
            if (eleAndGroup[i] ==qgroup){
                eleAndGroup[i] = pGroup;
            }
        }
        this.count--;
    }
}
