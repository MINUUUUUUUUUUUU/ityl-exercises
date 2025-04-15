package chapter01_to_05.exercise.advanced2;

public class exercise_8 {
    public static void main (String[] args) {
        int [][] array = {
                {95, 86}, {83,92,96}, {78,83,93,87,88}
        };

        int sum = 0;

        for (int[] ary : array)
        {
            for (int num : ary)
            {
                sum += num;
            }
        }

        System.out.println(sum);
    }
}
