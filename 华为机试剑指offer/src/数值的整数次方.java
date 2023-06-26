import java.math.BigDecimal;

public class 数值的整数次方 {
    public static void main(String[] args) {
        System.out.println(Math.pow(2.0000, 10));
        Solution24 solution24 = new Solution24();
        System.out.println(solution24.getResult(2.0, -2));
    }
}

class Solution24 {

    public double getResult(double x, int n) {
        if (x == 1.0) return 1.0;
        if (x == 0) return 0;
        if (n == 0) return 1;
        double res = 1.0;
        for (int i = 0; i < Math.abs(n); i++) {
            res = res * x;
        }
        return n < 0 ? 1.0 / res : res;
    }

    public double myPow(double x, int n) {
        double result = 1.0;
        for (int i = n; i != 0; i /= 2) {
            x *= x;
            if (i % 2 != 0) {
                //i是奇数
                result *= x;
            }
        }
        return n < 0 ? 1.0 / result : result;
    }

}
