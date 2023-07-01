import java.util.Scanner;

public class 整数除法001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            new 整数除法001().divide(a, b);
        }
    }


    public int divide(int a, int b) {
        // 首先判断越界情况，即-128变成128这种。因为int的表示范围-2^31——2^31-1。最小的负数转换正数会溢出
        if (a == Integer.MIN_VALUE && b == -1) {
            System.out.println(Integer.MAX_VALUE);
            return Integer.MAX_VALUE; //越界1
        }
        // 记录正负数情况，我们全部变成负数，因为-128不能变成正数
        boolean flag = true; //最后结果为负
        if (a > 0 && b > 0 || a < 0 && b < 0) {
            flag = false;
        }
        a = a > 0 ? -a : a;
        b = b > 0 ? -b : b;
        // 计算结果，采用除数倍增法，直接每次乘以2倍增，对应的次数也是倍增的
        int ans = 0;
        int tempAns;
        int divideB = b;
        // 每一轮找到该被除数下最大的那个可以减的数，必须是2倍增的即x2
        while (a <= b) { //必须是等于哦，a=b时
            tempAns = 1;
//            while (a <= 2 * b) { // 啊，我知道到了，这里当b为-2147483648时，执行这个就会溢出了
            while ((a - b) <= b) { // 这样就行了，所以有三个地方要解决溢出问题
                b = 2 * b;
                tempAns = 2 * tempAns;
            }
            a = a - b;
            b = divideB;
            ans += tempAns;
        }
        ans = flag ? -ans : ans;  //这里对于-2147483648/1是如何处理的？
        System.out.println(ans);
        return ans;
    }
}
