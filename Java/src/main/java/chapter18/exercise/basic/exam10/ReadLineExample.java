package chapter18.exercise.basic.exam10;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadLineExample {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("./test3.txt"));

        int line = 0;
        while (true) {
            String s = br.readLine();
            if (s == null) break;
            System.out.println(s);
            line++;
        }
        br.close();
    }
}
