package chapter08.exercise.basic.exam05;

public class CastingExample {
    public static void main(String[] args) {
        Vehicle v = new Bus();

        v.run();
//        v.checkFare();

        Bus bus = (Bus) v;
        bus.run();
        bus.checkFare();
    }
}
