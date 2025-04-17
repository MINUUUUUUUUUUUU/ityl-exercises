package chapter07.sec12;

public class AnimalExample {
    public static void main(String[] args) {
        Animal[] animals = new Animal[3];

        animals[0] = new Animal();
        animals[1] = new Dog();
        animals[2] = new Cat();

        System.out.println("동적 바인딩 사용 X");
        for(Animal animal : animals) {
            if(animal instanceof Dog) {
                ((Dog)animal).sound();
            }
            else if(animal instanceof Cat) {
                ((Cat)animal).sound();
            }
            else {
                animal.sound();
            }
        }

        System.out.println("동적 바인딩 사용 O");
        for (Animal animal : animals) {
            animal.sound();
        }
    }
}
