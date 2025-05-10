package chapter18.exercise.advanced.exam02;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExample2 {
    public static void main(String[] args) throws  Exception {
        File dir = new File("./");
        File[] file = new File("./").listFiles();
        if(!dir.exists()) { dir.mkdirs(); }
        for(File f : file) {
            if(!f.exists()) {
                f.createNewFile();
            }
        }

        File temp = new File("C:/Temp");
        File[] contents = temp.listFiles();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for(File f : contents) {
            System.out.printf("%-25s", sdf.format(new Date(f.lastModified())));
            if(f.isDirectory()) {
                System.out.printf("%-10s%-20s", "<DIR>", f.getName());
            } else {
                System.out.printf("%-10s%-20s", f.length(), f.getName());
            }
            System.out.println();
        }

    }
}
