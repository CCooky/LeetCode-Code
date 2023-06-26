import java.util.Scanner;

public class 翻转单词顺序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        getRes(s);
    }
    //
    public static String getRes(String s){
        //1.
        s = s.trim();
        if (s.length()==0) return "";
        String[] split = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = split.length-1; i >=0 ; i--) {
            if (!split[i].equals("")){
                stringBuilder.append(split[i]).append(" ");
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        String resString = stringBuilder.toString();
        System.out.println(resString);
        return resString;

    }
}
