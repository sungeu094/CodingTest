package function;

public class MyFuncMain {
    public static void main(String[] args) {
        MyFunc func = () -> System.out.println("Hello!");
        func.doSomething();
    }
}
