package chapter18.exercise.basic.exam03;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExample {
    public static void main(String[] args) {
        try {
            InputStream in = new FileInputStream("./test.db");
            while (in.available() > 0) {
                System.out.println(in.read());
            }
            in.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
