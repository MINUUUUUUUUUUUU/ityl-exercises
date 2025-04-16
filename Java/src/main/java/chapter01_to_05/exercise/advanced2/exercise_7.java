package chapter01_to_05.exercise.advanced2;

public class exercise_7 {
    public static void main (String[] args) {
        int [] array = {1,5,3,8,2};
        int max = -1;

        for (int number: array) {
            if (max < number) {
                max = number;
            }
        }
        System.out.println(max);
    }
}
