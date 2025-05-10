package chapter18.exercise.basic.exam01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {
    public static void main(String[] args) {
        try {
            OutputStream os = new FileOutputStream("./test.db");

            byte a = 1;
            byte b = 2;
            byte c = 3;

            os.write(a);
            os.write(b);
            os.write(c);

            os.flush();
            os.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}
