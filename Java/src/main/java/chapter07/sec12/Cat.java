package chapter07.sec12;

public class Cat extends Animal {
    public Cat() {
        name= "나비";
    }

    @Override
    public void sound() {
        System.out.println(name + " : Meow");
    }
}
