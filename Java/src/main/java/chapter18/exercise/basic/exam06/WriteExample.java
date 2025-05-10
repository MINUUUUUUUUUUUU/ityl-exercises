package chapter18.exercise.basic.exam06;

import java.io.FileWriter;
import java.io.Writer;

public class WriteExample {
    public static void main(String[] args) {
        char a = 'A';
        char b = 'B';
        char[] arr = { 'C', 'D', 'E' };

        try {
            Writer os = new FileWriter("./test.txt");
            os.write(a);
            os.write(b);
            os.write(arr);
            os.close();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
