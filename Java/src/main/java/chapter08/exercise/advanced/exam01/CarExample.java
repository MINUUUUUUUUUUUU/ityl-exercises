package chapter08.exercise.advanced.exam01;

public class CarExample {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.run();

        myCar.tire1 = new KumhoTire();
        myCar.tire2 = new KumhoTire();

        myCar.run();
    }
}
