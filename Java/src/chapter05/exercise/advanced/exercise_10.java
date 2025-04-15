package chapter05.exercise.advanced;
import java.util.Scanner;


public class exercise_10 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = 0;

        System.out.println("------------------------------------------------");
        System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
        System.out.println("------------------------------------------------");

        System.out.print("선택>");
        input = scanner.nextInt();

        if (input != 1) {
            System.out.println("처음엔 학생수를 입력해야합니다! 학생 수를 입력해주세요.");
        }

        do {
                System.out.print("학생수>");
                int count = scanner.nextInt();
                int[] scores = new int[count];

                do {
                    System.out.println("------------------------------------------------");
                    System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
                    System.out.println("------------------------------------------------");
                    System.out.print("선택>");
                    input = scanner.nextInt();

                    switch (input) {
                        case 2:
                            for (int i = 0; i < count; i++) {
                                System.out.print("scores[" + i + "]>");
                                scores[i] = scanner.nextInt();
                            }
                            break;
                        case 3:
                            for (int i = 0; i < count; i++) {
                                System.out.println("scores[" + i + "]>" + scores[i]);
                            }
                            break;
                        case 4:
                            int max = 0;
                            int avg = 0;

                            for (int i = 0; i < count; i++) {
                                if (scores[i] > max) {
                                    max = scores[i];
                                }

                                avg += scores[i];
                            }
                            avg /= count;

                            System.out.println("최고 점수: " + max);
                            System.out.println("평균 점수: " + avg);
                    }

                } while (input != 5 && input != 1);


        } while (input != 5);
    }
}
