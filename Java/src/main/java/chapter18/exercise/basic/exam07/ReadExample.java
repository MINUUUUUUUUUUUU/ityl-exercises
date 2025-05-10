package chapter18.exercise.basic.exam07;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class ReadExample  {
    public static void main(String[] args) throws Exception {
        try {
            Reader reader = new FileReader("./test.txt");
            char[] buf = new char[1024];
            int numRead = 0;

            while (true) {
                numRead = reader.read(buf);
                if (numRead == -1) { break; }
                for (int i = 0; i < numRead; i++) {
                    System.out.print(buf[i]);
                }
                System.out.println();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
