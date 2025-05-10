package chapter18.exercise.basic.exam09;

import java.io.*;

public class BufferExample {
    public static void main(String[] args) throws Exception {
        String originalFilePath1 =
                BufferExample.class.getResource("originalFile1.jpg").getPath();
        String targetFilePath1 = "./target.jpg";

        FileInputStream fis = new FileInputStream(originalFilePath1);
        FileOutputStream fos = new FileOutputStream(targetFilePath1);

        String originalFilePath2 = BufferExample.class.getResource("originalFile2.jpg").getPath();
        String targetFilePath2 = "./target.jpg";
        FileInputStream fis2 = new FileInputStream(originalFilePath2);
        FileOutputStream fos2 = new FileOutputStream(targetFilePath2);
        BufferedInputStream bis = new BufferedInputStream(fis2);
        BufferedOutputStream bos = new BufferedOutputStream(fos2);

        long nonBufferTime = copy(fis, fos);
        System.out.println(nonBufferTime);

        long bufferTime = copy(bis, bos);
        System.out.println(bufferTime);

        fis.close();
        fos.close();
        bis.close();
        bos.close();
    }

    public static long copy(InputStream in, OutputStream out) throws IOException {
        long start = System.nanoTime();
        while(true) {
            int data = in.read();
            if(data == -1) { break; }
            out.write(data);

        }
        out.flush();

        long end = System.nanoTime();
        return end - start;
    }
}
