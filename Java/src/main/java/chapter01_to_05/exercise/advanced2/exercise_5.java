package chapter01_to_05.exercise.advanced2;

public class exercise_5 {
    public static void main (String[] args) {
        for (int x=0; x<=10; x++)
        {
            for (int y=0; y<=10; y++)
            {
                if ((4*x + 5*y) == 60) {
                    System.out.println("(" + x + "," + y + ")");
//                    System.out.println(x , y);
                }
            }
        }
    }
}
