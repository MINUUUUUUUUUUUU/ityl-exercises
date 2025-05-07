package chapter16.exam03;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodRefTest {
    public static void main(String[] args) {
        Function<Integer, Integer> abs1 = new Function<Integer, Integer>() {
            public Integer apply(Integer a) {
                return Math.abs(a);
            }
        };

        abs1.apply(-1);

        Function<Integer, Integer> abs2 = integer -> Math.abs(integer);

        abs2.apply(-2);

        Function<Integer, Integer> abs3 = Math::abs;

        abs3.apply(-3);

        String str = "Hello World";
        Supplier<String> lower1 = new Supplier<String>() {
            @Override
            public String get() {
                return str.toLowerCase();
            }
        };

        System.out.println(lower1.get());


        // -------------------------------------------------------------------------------------------------------------

        Function<String, Integer> strLength = String::length;
//        Function<String, Integer> strLength2 = str::length;   인스턴스 형태로는 안된다!

        List<String> nameList = new ArrayList<>();
        nameList.add("A");
        nameList.add("B");
        nameList.add("C");
        nameList.add("D");

        nameList.forEach(System.out::println);


        BinaryOperator<Integer> operator1 = (a, b) -> a + b;
        System.out.println(sumTwoNumbers(operator1, 1, 2));
    }

    public static int sumTwoNumbers(BinaryOperator<Integer> op, int a, int b) {
        return op.apply(a, b);
    };

    public static int sum(int a, int b) {
        return a + b;
    }
}
