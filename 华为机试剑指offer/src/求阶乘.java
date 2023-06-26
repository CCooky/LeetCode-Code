public class 求阶乘 {
    public static void main(String[] args) {
        int res = getRes2(9);
        System.out.println(res);
    }

    /**
     * 先写递归的版本，然后我们想办法去掉这个if条件
     */
    // 返回值：出入数字n的累计和结果
    public static int getRes(int n) {
        if (n == 1) return 1;
        n = n + getRes(n - 1);
        return n;
    }
    /**
     * 想起来我们的短路逻辑运算，&& || 前面一个假如满足要求后面就不会再执行了
     * 与此对应的是 & | 这两个是两边一定会执行
     */
    public static int getRes2(int n) {
        // n>1成立时，后面的一定会执行；
        // n>1不成立时，后面的就不用执行了
        boolean b = n > 1 && (n += getRes(n - 1))>1000000; //这个>1000随便写，不然会报错
        return n;
    }
}
