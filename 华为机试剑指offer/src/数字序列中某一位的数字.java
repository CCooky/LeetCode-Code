import java.util.Scanner;

public class 数字序列中某一位的数字 {
    public static void main(String[] args) {
        System.out.println(10^2);
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Solution40 solution40 = new Solution40();
//        solution40.findNthDigit(n);
        solution40.getResult(11);
    }
}

class Solution40 {
    public int getResult(int n) {
        int t = 1; //当前的数位长度
        int maxLen = 10; //当前数位长度下，最大字符序长度
        while (n > maxLen) {
            t++;
            maxLen = (10 ^ t) * t - maxLen;
        }
        StringBuilder stringb = new StringBuilder();
        for (int i = 0; i < (10 ^ t); i++) {
            stringb.append(String.valueOf(i));
        }
        return Integer.parseInt(String.valueOf(stringb.charAt(n)));
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
