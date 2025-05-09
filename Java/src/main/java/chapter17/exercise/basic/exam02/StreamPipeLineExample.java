package chapter17.exercise.basic.exam02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPipeLineExample {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("홍길동", 10),
                new Student("신용권", 20),
                new Student("유미선", 30)
        );

        Stream<Student> stream = list.stream();
        IntStream intStream = list.stream().mapToInt(Student::getScore);
        double avg = intStream.average().getAsDouble();
        System.out.println("평균 점수: " + avg);
    }

}
