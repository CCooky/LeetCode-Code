import java.util.Objects;
import java.util.Scanner;

public class scanner {
    public static  void main(String[] args){
        Scanner sc = new Scanner(System.in);
//        while (sc.hasNextLine()){
        while (true){
            String str = sc.nextLine();
            if(Objects.equals(str,"")){ //当键盘输入空字符串时结束
                break;
            }
            System.out.println(str);
        }
    }
}
