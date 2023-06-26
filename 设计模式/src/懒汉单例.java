public class 懒汉单例 {
    public static void main(String[] args) {
        SingleInstance2 singleInstance = SingleInstance2.getSingleInstance();
        SingleInstance2 singleInstance2 = SingleInstance2.getSingleInstance();
        System.out.println(singleInstance == singleInstance2);
    }
}
class SingleInstance2{
    //
    private SingleInstance2(){}

    //
    private static SingleInstance2 singleInstance;

    //
    public static SingleInstance2 getSingleInstance(){
        if (singleInstance==null){
            singleInstance = new SingleInstance2();
        }
        return singleInstance;
    }
}
