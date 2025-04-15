package chapter01_to_05.exercise.basic2;

public class exercise_2 {
    public static void main(String[] args) {
        int score = 88;

        // 문제 조건에서 점수가 90일땐 생각하지 않음
        if  (0<= score && score < 70) {
            System.out.println("점수가 0~69입니다");
            System.out.println("등급은 D입니다.");
        }
        else if (70<= score && score < 80) {
            System.out.println("점수가 70~79입니다.");
            System.out.println("등급은 C입니다.");
        }
        else if (80<= score && score < 90) {
            System.out.println("점수가 80~89입니다.");
            System.out.println("등급은 B입니다.");
        }
        else if (90<= score && score <= 100) {
            System.out.println("점수가 90~100입니다.");
            System.out.println("등급은 A입니다.");
        }
    }
}
