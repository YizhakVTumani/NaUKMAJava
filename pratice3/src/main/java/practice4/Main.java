package practice4;

public class Main {
    public static void main(String[] args){
        Animal[] a = new  Animal[] { new Cat(),new Dog(), new Cat()};
        for (Animal a1 : a) {
            a1.speak();
        }
    }
}
abstract class Animal{
    abstract void speak();
}
class Dog extends Animal{
    @Override
    void speak() {
        System.out.println("Gaf");
    }
    public void fetch(){
        System.out.println("Stick!");
    };
}
class Cat extends Animal{
    @Override
    void speak() {
        System.out.println("Meow");
    }
}
