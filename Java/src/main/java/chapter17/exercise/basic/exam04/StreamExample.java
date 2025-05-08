package chapter17.exercise.basic.exam04;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        String[] strArray = { "홍길동", "신용권", "김미나"};
        int[] intArray = { 1, 2, 3, 4, 5 };

        Stream<String> stream = Arrays.stream(strArray);
        stream.forEach( p -> System.out.print(p +","));

        System.out.println();

        IntStream intStream  = Arrays.stream(intArray);
        intStream.forEach(i -> System.out.print(i +","));
    }
}

