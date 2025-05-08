package chapter17.exercise.advanced.exam03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatMappingExample {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("this is java");
        list1.add("i am a best developer");

        list1.stream().flatMap(s -> Arrays.stream(s.split(" "))).forEach(System.out::println);

        System.out.println();

        List<String> list2 = Arrays.asList("10, 20, 30", "40, 50");
        list2.stream().flatMap(s -> Arrays.stream(s.split(", "))).forEach(s -> System.out.println(s));
    }
}
