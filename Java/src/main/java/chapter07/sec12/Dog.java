package chapter07.sec12;

public class Dog extends Animal {
    public Dog() {
        super.name = "Ppopi";
    }

    @Override
    public void sound() {
        System.out.println(name + " : Bow-wow");
    }
}
