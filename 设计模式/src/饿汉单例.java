public class 饿汉单例 {
    public static void main(String[] args) {
        SingleInstance1 instance = SingleInstance1.singleInstance;
        System.out.println(instance.age);

    }
}
class SingleInstance1{
    //1.
    private SingleInstance1(int age){
        this.age = age;
    }
    //2.
    public static SingleInstance1 singleInstance = new SingleInstance1(18);

    public int age;

}
