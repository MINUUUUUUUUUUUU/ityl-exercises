package chapter05.exercise.basic;

public class exercise_2 {
    public static void main(String[] args) {
        int score = 85;
// int score = 93

        // 문제 조건에서 점수가 90일땐 생각하지 않음
        if  (score > 90) {
            System.out.println("점수가 90보다 큽니다");
            System.out.println("등급은 A입니다.");
        }
        else if (score < 90) {
            System.out.println("점수가 90보다 작습니다.");
            System.out.println("등급은 B입니다.");
        }
    }
}
