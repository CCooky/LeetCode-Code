import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        Integer a = new Integer(111);//会主动new
        Integer b = 111; //取缓存对象地址
        System.out.println(a==b);  //false

        Integer c = 111;
        System.out.println(b==c); //true

        //
        Random random = new Random();
        System.out.println(random.nextInt()); // int类型范围内随机
        System.out.println(random.nextInt(100)); // [0, 100) 随机
        System.out.println(random.nextInt(200) - 100); // [-100, 100) 随机
        System.out.println(random.nextLong()); // long类型范围内随机
        System.out.println(random.nextDouble()); //[0.0, 1.0)
        System.out.println(random.nextBoolean());

        // Comparator比较器对象。
        int[] ages = {34, 12, 42, 23};
        Arrays.sort(ages);
        System.out.println(Arrays.toString(ages));

        Integer[] ages1 = {34, 12, 42, 23};
        Arrays.sort(ages1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1; //  降序
            }
        });
        //Lambda简化函数式接口
        Arrays.sort(ages1,(o1, o2) -> o2-o1);
        System.out.println(Arrays.toString(ages1));
    }



}

