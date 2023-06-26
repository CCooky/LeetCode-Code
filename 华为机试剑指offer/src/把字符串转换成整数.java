import java.util.Objects;
import java.util.Scanner;

public class 把字符串转换成整数 {
    public static void main(String[] args) {
        //输入会有小数，但小数点那里会被判断的时候去掉
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            System.out.println(getRes(s));
        }

    }

    //
    public static int getRes(String s) {

        String trim = s.trim();
        if (Objects.equals(trim, "")) {
            return 0; //无法转换
        }
        char c1 = trim.charAt(0);
        StringBuilder stringBuilder = new StringBuilder();
        if (c1 == '+') {
            /**
             * 1、之前没有考虑索引越界情况。只有一个字符+
             */
            if (trim.length() == 1) return 0;
            if (trim.charAt(1) < '0' || trim.charAt(1) > '9') return 0;
            stringBuilder.append('+');
            for (int i = 1; i < trim.length(); i++) {
                if (trim.charAt(i) >= '0' && trim.charAt(i) <= '9') {
                    stringBuilder.append(trim.charAt(i));
                } else break;
            }
        } else if (c1 == '-') {
            if (trim.length() == 1) return 0;
            stringBuilder.append('-');
            if (trim.charAt(1) < '0' || trim.charAt(1) > '9') return 0;
            for (int i = 1; i < trim.length(); i++) {
                if (trim.charAt(i) >= '0' && trim.charAt(i) <= '9') {
                    stringBuilder.append(trim.charAt(i));
                } else break;
            }
        } else if (c1 >= '0' && c1 <= '9') {
            stringBuilder.append('+');
            for (int i = 0; i < trim.length(); i++) {
                if (trim.charAt(i) >= '0' && trim.charAt(i) <= '9') {
                    stringBuilder.append(trim.charAt(i));
                } else break;
            }
        } else {
            return 0;
        }
        // 最后int范围判断。
        /**
         * 去除前导0，真的麻烦 【-0000000000012345678】
         */
        int index = -1;  //求出第一个非0整数的索引位置
        for (int i = 1; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) != '0') {
                index = i;
                break;
            }
        }
        String resString;
        if (index == -1) return 0;
        else {
            resString = stringBuilder.charAt(0)+ stringBuilder.substring(index,stringBuilder.length());
        }
        //
        /**
         * 2、妈的，输入字符串比long都长，这怎么搞，先直接判断位数吧，int最多表示10位十进制
         */
        if (resString.length() > 15) {
            if (resString.charAt(0) == '-') return Integer.MIN_VALUE;
            else return Integer.MAX_VALUE;
        }
        long l = Long.parseLong(resString);
        if (l >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (l <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) l;
    }
}
