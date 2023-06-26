import java.util.Arrays;

/**
 *
 */
public class 分发饼干 {
}

class Solution {
    /**
     * 这个题目简单的东西在于：每个孩子只能有一块，如果多块就难了，并且没有说要饼干尽量不浪费，如果说尽量不浪费就难了
     * 我们还是按照优质的解法：加上这个尽量不浪费条件，如果孩子胃口是2，并且现在还有2的饼干那我们就喂2，不要喂更大的；
     * 孩子应该从小到大遍历，同时指针也是从左到右，这样才是做到尽量不浪费
     * hhhhhhhhhhh，有点问题，假如g=【1，200】，s=【300】，那好搞笑啊。
     * 那假如先满足大的孩子，两个数组就都是从后开始遍历，就会 g=【1，1】，s=【1，1，200，300】
     * 其实最优解就是 两个for，每个孩子找到第一个 大于大于的饼干给他，同时记录该饼干已经使用过，然后break去接着满足下一个孩子
     */
    public int findContentChildren(int[] g, int[] s) {
        //1.两个组从小到大排序先
        Arrays.sort(g);
        Arrays.sort(s);
        //2.采用一个for循环遍历孩子，然后加一个指针指向饼干，千万不要两个for啊，因为已经发出去的饼干就没有了
        // 孩子应该从小到大遍历，同时指针也是从左到右，这样才是做到尽量不浪费
        int funChildNum = 0;
        int spoint = 0;
        for (int appetite : g) {
            //  如果当前饼干大小不满足的话，就要一直找到满足的饼干大小
            while (spoint <= s.length - 1) {
                if (s[spoint] >= appetite) {
                    funChildNum++; //
                    spoint++; //指针后移
                    break;
                }
                if (s[spoint] < appetite) {
                    spoint++;
                }
            }
        }
        return funChildNum;
    }
}
