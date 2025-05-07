package chapter16.exam02;

import java.util.Random;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class SupplierTest {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> { return "짱구"; };
        System.out.println(supplier.get());

        IntSupplier supplier2 = () -> {
            Random random = new Random();
            return random.nextInt(100);
        };
        System.out.println(supplier2.getAsInt());
        System.out.println(supplier2.getAsInt());
    }
}
