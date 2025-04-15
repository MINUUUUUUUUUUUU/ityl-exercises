package chapter01_to_05.exercise.basic;

public class exercise_33 {
    public static void main(String[] args) {

        int[] oldIntArray = { 1, 2, 3 };
        int[] newIntArray = new int[5];

        System.arraycopy(oldIntArray, 0, newIntArray, 0, oldIntArray.length);

        for (int j : newIntArray) {
            System.out.print(j + ", ");
        }
    }
}
