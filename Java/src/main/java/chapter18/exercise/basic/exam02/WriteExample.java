package chapter18.exercise.basic.exam02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {
    public static void main(String[] args) {

        OutputStream os;
        byte[] array = { 10, 20, 30 };


        {
            try {
                os = new FileOutputStream("./test2.db");

                os.write(array);


            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
