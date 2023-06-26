import java.util.Scanner;

public class 数字序列中某一位的数字 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Solution40 solution40 = new Solution40();
        solution40.findNthDigit(n);
    }
}

class Solution40 {
    public int getResult(int n) {
        //根据n的大小，我们初始化一个字符串stringbuilder即可、
        //n=3,我们就初始化0123；n是指的索引
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            stringBuilder.append(i);
        }
        char c = stringBuilder.charAt(n); //随机访问O（1）
        return Integer.parseInt(String.valueOf(c));
    }

    public int findNthDigit(int n) {
        // 每个数字字符宽度都补成当前位数i, 那么最后我们要找的数字区间的数是 k/i ,区间内最后得到的数是 k%i.
        // 例如i为3时，数字序列补为 000 001 002 003 004 005 006 007 008 009 010 011... 前面补0后n要右移对应的长度
        // 例如求n=11时，由于11>10,所以把前面的0..9都补一个0，n=21，那么就是先得到10这个数字（21/2），然后索引是1（21%2）。
        long k = n;
        int i = 1;
        while (true) {
            if (i * Math.pow(10, i) > k) {
//                String s = k / i + "";
                String s = String.valueOf(k / i);
                return s.charAt((int) (k % i)) - '0';
            }
            k += Math.pow(10, i);
            i++;
        }
    }

}
