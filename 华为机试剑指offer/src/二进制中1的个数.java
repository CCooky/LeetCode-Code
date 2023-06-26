public class 二进制中1的个数 {
}
class Solution20 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int t = 1 << i; // 数字1依次右移，判断32个比特位
            if ((n & t) !=0) { //判断第1位比特位是不是1，假如结果不为0，则是1
                res++;
            }
        }
        return res;
    }
}
