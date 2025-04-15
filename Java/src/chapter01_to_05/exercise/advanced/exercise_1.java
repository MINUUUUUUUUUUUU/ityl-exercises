package chapter01_to_05.exercise.advanced;

public class exercise_1
{
    public static void main (String[] args) {
        int result = 0;

        for(int i=0; i<100; i++){
            if ((i+1) % 3 == 0) {
                result += (i+1);
            }
        }
        System.out.println(result);
    }
}
