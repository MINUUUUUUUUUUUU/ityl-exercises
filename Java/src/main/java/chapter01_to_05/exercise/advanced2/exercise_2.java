package chapter01_to_05.exercise.advanced2;

public class exercise_2 {

    public static void main (String[] args) {
        for (int i=0; i<6; i++){
            for (int j=0; j<i; j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
