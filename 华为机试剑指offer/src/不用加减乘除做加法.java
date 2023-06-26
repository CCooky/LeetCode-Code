public class 不用加减乘除做加法 {
    public static void main(String[] args) {
        getRes(-1,2);
    }

    public static int getRes(int a, int b){
        int t1 = (a&b) <<1; //进位
        int t2 = a^b; //非进位
        while (t1!=0){ //stop：进位为0啊，必须是进位
            int tt = (t1&t2) <<1;
            t2 = t1^t2;
            t1 = tt;
        }
        System.out.println(t2);
        return t2;
    }
}
