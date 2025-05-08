package chapter17.exam01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DelayOperation {
    public static void main(String[] args) throws InterruptedException {

        List<String> names = Arrays.asList("김철수", "영희", "박민수");

        Stream<String> stream = names.stream()
                .filter(name -> {
                    System.out.println("filter: " + name);
                    return name.length() > 2;
                })
                .map(name -> {
                    System.out.println("map: " + name);
                    return name.toUpperCase();
                });
        // 여기까지는 아무 출력도 없음 (중간 연산만 정의했기 때문)

        Thread.sleep(3000); // 3초간 스레드 지연

        // 최종 연산 호출
        List<String> result = stream.collect(Collectors.toList());
    }
}