package chapter08.exercise.advanced.exam01;

public class Car {
    Tire tire1 = new HankookTire();
    Tire tire2 = new HankookTire();

    public void run(){
        tire1.roll();
        tire2.roll();
    }
}
