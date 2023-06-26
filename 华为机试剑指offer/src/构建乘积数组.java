import java.util.Arrays;

public class 构建乘积数组 {
    public static void main(String[] args) {

    }

    public static int[] getRes(int[] a){
        //1、从前往后
        int[] nums1 = new int[a.length];
        int mulptiply = 1;
        for (int i = 0; i < a.length; i++) {
            nums1[i] = mulptiply;
            mulptiply *= a[i];
        }
        //2、从后往前
        int[] nums2 = new int[a.length];
        mulptiply = 1;
        for (int i =  a.length-1; i >=0; i--) {
            nums2[i] = mulptiply;
            mulptiply *= a[i];
        }
        //3、对应相乘
        int[] res = new int[a.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = nums1[i] * nums2[i];
        }
        System.out.println(Arrays.toString(res));
        return res;
    }
}
