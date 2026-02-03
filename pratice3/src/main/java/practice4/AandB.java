package practice4;

public class AandB {
    public static void main(String[] args) {
        A a = new B();
        a.process("hi");
    }
}
class A{
    public void process(Object o){
        System.out.printf("A obj");
    }
}
class B extends A{
    @Override
    public void process(Object o){
        System.out.printf("B obj");
    }

    public void process(String str){
        System.out.printf("B str");
    }
}
