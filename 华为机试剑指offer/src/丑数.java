import java.util.*;

public class 丑数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //第n个丑数
        getRes(n);

    }
    public static int getRes(int n) {
        //使用list存储n个丑数即可
        List<Integer> list = new ArrayList<>();
        list.add(1); //特殊的丑数先加进来
        int num = 2;
        while (true) {
            if (list.size() == n) {
                break; //已经找到了前面n个丑数
            }
            if (isValid(num)){
                list.add(num);
            }
            num++;
        }
        System.out.println(list.get(n - 1));
        return list.get(n - 1);
    }

    //判断正整数的质因子是否仅仅只有2、3、5这三个里面的
    public static boolean isValid(int n) {
        int[] num = new int[]{2, 3, 5};
        for (int i = 0; i < num.length; i++) {
            while (n % num[i] == 0) {
                n /= num[i];
            }
        }
        //如果最后 n==1，说明n仅仅可以被 2、3、5这三个整除
        return n == 1;
    }
}
