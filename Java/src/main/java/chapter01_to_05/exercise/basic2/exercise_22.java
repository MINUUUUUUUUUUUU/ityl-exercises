package chapter01_to_05.exercise.basic2;

public class exercise_22 {
    public static void main(String[] args) {
        String ssn = "9506241230123";
        int length = ssn.length();
        if(length == 13) {
            System.out.println("주민등록번호 자릿수가 맞습니다.");
        } else {
            System.out.println("주민등록번호 자릿수가 틀립니다.");
        }
    }
}
