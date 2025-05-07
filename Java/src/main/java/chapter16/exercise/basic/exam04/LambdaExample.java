package chapter16.exercise.basic.exam04;

public class LambdaExample {
    public static void main(String[] args) {
        Person person = new Person();

        person.action(
                (x, y) -> {
                    double result = sum(x, y);
                    return result;
                }
        );

        person.action(LambdaExample::sum);
    }

    public static double sum(double x, double y) {
        return x + y;
    }
}
