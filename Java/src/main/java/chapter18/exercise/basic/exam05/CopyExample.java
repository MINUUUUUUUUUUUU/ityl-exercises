package chapter18.exercise.basic.exam05;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyExample {
    public static void main(String[] args) throws Exception {
        String originFileName = "./test.jpg";
        String targetFileName = "./test2.jpg";

        InputStream in = new FileInputStream(originFileName);
        OutputStream out = new FileOutputStream(targetFileName);

        byte[] buf = new byte[1024];
        while (true) {
            int len = in.read(buf);
            if (len == -1) { break; }
            out.write(buf, 0, len);
        }

        out.flush();
    }
}
