package chapter16.exam02;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerTest {
    public static void main(String[] args) {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        consumer.accept("노람다람다");

        Consumer<String> consumer2 = (String s2) -> {
            System.out.println(s2);
        };

        consumer2.accept("람다람다");

        BiConsumer<String, Integer> biConsumer = (s1, s2) -> {
            System.out.println(s1);
            System.out.println(s2);
        };

        biConsumer.accept("바이컨슈머", 999);
    }
}
