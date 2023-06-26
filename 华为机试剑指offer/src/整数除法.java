public class 整数除法 {
    public static void main(String[] args) {
        new 整数除法().divideAC(-2147483648, -1);
        new 整数除法().divideAC(-2147483648, 1);
    }

    public int divide(int a, int b) {
        // 记录正负数情况，我们全部变成负数。因为int的表示范围-2^31——2^31-1。最小的负数转换正数会溢出
        boolean flag = false;
        if (a > 0) {
            a = -a;
            flag = !flag;
        }
        if (b > 0) {
            b = -b;
            flag = !flag;
        }
        // 计算结果，累加法，会超时的
        int ans = 0;
        int val = b; //每次加一个val（b）
        while (a <= b) {
            ans++;
            b += val;
        }
        ans = flag ? -ans : ans;
        System.out.println(ans);
        return ans;
    }

    public int divideAC(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1) {
            System.out.println(Integer.MAX_VALUE);
            return Integer.MAX_VALUE; //越界1
        }
        // 记录正负数情况，我们全部变成负数。因为int的表示范围-2^31——2^31-1。最小的负数转换正数会溢出
        boolean flag = false;
        if (a > 0) {
            a = -a;
            flag = !flag;
        }
        if (b > 0) {
            b = -b;
            flag = !flag;
        }
        // 计算结果，采用除数倍增法，直接每次乘以2倍增，对应的次数也是倍增的
        int ans = 0;
        int tempAns = 0;
        int divideB = b;
        while (a <= b) {
            tempAns = 1; //单次的结果
            while ( b>= Integer.MIN_VALUE>>1 && a <= b << 1) { //这里b<<1可能会越界2，所以要加一个条件
                b += b;
                tempAns += tempAns;
            }
            a = a - b;
            b = divideB;
            ans += tempAns;
        }
        ans = flag ? -ans : ans;
        System.out.println(ans);
        return ans;
    }
}


