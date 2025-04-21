package chapter08.exercise.advanced.exam03;

public class Bus implements Vehicle {
    @Override
    public void run() {
        System.out.println("Bus Run");
    }

    public void checkFare() {
        System.out.println("Bus Check Fare");
    }
}
