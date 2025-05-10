package chapter18.exercise.basic.exam08;

import java.io.*;

public class CharacterConvertStreamExample {
    public static void main(String[] args) throws Exception {
        String str = "문자 변환 스트림을 사용합니다.";
        write(str);
        String data = read();
        System.out.println(data);
    }

    public static void write(String str) throws Exception {
        OutputStream os = new FileOutputStream("./test.txt");
        Writer writer = new OutputStreamWriter(os, "UTF-8");
        writer.write(str);
        writer.flush();
        writer.close();
    }

    public static String read() throws Exception {
        InputStream in = new FileInputStream("./test.txt");
        Reader reader = new InputStreamReader(in, "UTF-8");
        char[] buf = new char[100];
        int num = reader.read(buf);
        reader.close();
        String str = new String(buf, 0, num);
        return str;
    }
}
