import java.util.Scanner;

public class 表示数值的字符串 {
    //["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        Solution13 solution13 = new Solution13();
        boolean number = solution13.isNumber(s);
        System.out.println(number);
    }
}

class Solution13 {
    public boolean isNumber(String s){
        //预处理，去掉空格
        if (s==null || s.length()==0) return false;
        char[] chars = s.trim().toCharArray();

        //挨个判断；
        //1、对于点. 只能出现一次，一种是纯小数，一种是出现在e的前面；
        //2、对于e，只能出现一次，e的前面必须出现数，e的后面必须出现整数（可以带符号）
        //3、对于+-，只能出现在第一个位置，或者出现在e的后面第一个位置
        //4、对于数字，只能是0-9
        boolean numFlag = false;
        boolean dotFlag = false;
        boolean eFlag = false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='.'){
                // 这里只判断不成立的情况；点前面不能出现e，也不能再出现点
                if (eFlag || dotFlag) {
                    return false;
                }
                dotFlag = true;
            }else if (chars[i]=='e' || chars[i]=='E'){
                //这里只判断不成立的情况；e前面不能出现e，且前面必须出现了数字
                if (eFlag || !numFlag){
                    return false;
                }
                eFlag = true;
                numFlag = false; //出现了e之后，后面必须再出现整数。出现了点后面不一定要出现整数
            }else if (chars[i]=='+' || chars[i]=='-'){
                //只有两种情况才是对的，其他都是不成立
                if (i!=0 && chars[i-1]!='e' && chars[i-1]!='E'){
                    return false;
                }
            }else if (chars[i]>='0' && chars[i]<='9'){
                numFlag = true;
            }else { //出现其他字符均错误
                return false;
            }
        }
        return numFlag; //这里很重要哦，一定是返回numFlag，
    }
    public boolean isNumber2(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        //标记是否遇到相应情况；
        // 只能出现 数字、点、e/E和最前面+—的这几种情况
        boolean numSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;
        char[] str = s.trim().toCharArray(); //去除该字符串前后空格
        for (int i = 0; i < str.length; i++) {
            //
            if (str[i] >= '0' && str[i] <= '9') {
                numSeen = true;
            } else if (str[i] == '.') {
                //.之前不能出现.或者e。            只能出现一个点，因为e后面必须是整数
                if (dotSeen || eSeen) {
                    return false;
                }
                dotSeen = true;
            } else if (str[i] == 'e' || str[i] == 'E') {
                //e之前不能出现e, e之后不能出现点.        e前面必须是是小数/整数，但后面必须是整数
                if (eSeen || !numSeen) {
                    return false;
                }
                eSeen = true;
                numSeen = false;//重置numSeen，排除123e或者123e+的情况,确保e之后也出现数
            } else if (str[i] == '-' || str[i] == '+') {
                //+-出现在0位置或者e/E的后面第一个位置才是合法的
                if (i != 0 && str[i - 1] != 'e' && str[i - 1] != 'E') {
                    return false;
                }
            } else {//其他不合法字符
                return false;
            }
        }
        return numSeen;
    }
}
