package chapter01_to_05.exercise.basic2;

public class exercise_15 {
    public static void main(String[] args) throws Exception {
        while(true) {
            int num = (int)(Math.random()*6) + 1;
            System.out.println(num);
            if(num == 6) {
                break;
            }
        }
        System.out.println("프로그램 종료");
    }
}
