package chapter18.exercise.basic.exam04;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample {
    public static void main(String[] args) {
        try {
            InputStream is = new FileInputStream("./test2.db");
            byte[] data = new byte[is.available()];

            while (true) {
                int num = is.read(data);
                if (num == -1) { break; }
                for (int i = 0; i < num; i++) {
                    System.out.print(data[i] + ",");
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
