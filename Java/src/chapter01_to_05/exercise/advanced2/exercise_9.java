package chapter01_to_05.exercise.advanced2;
import java.util.Scanner;

public class exercise_9 {
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        int input = 0;
        int balance = 0;

        do {
            System.out.println("------------------------------");
            System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
            System.out.println("------------------------------");

            System.out.print("선택>");
            input = scanner.nextInt();

            switch(input) {
                case 1:
                    System.out.print("예금액>");
                    balance += scanner.nextInt();
                    break;
                case 2:
                    System.out.print("출금액>");
                    balance -= scanner.nextInt();
                    break;
                case 3:
                    System.out.println("잔고>" + balance);
                    break;
                default:

            }

        } while (input != 4);


    }
}
