package chapter17.exercise.basic.exam01;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("C");

        Stream<String> stream = set.stream();
        stream.forEach(System.out::println);
    }
}
