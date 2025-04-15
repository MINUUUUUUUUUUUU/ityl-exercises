package chapter01_to_05.exercise.basic2;

public class exercise_9 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i < 101; i++) {
            sum += i;
        }

        System.out.println("1~100 합: " + sum);
    }
}
