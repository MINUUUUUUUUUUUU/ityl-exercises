package chapter18.exercise.advanced.exam01;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamExample {
    public static void main(String[] args) throws Exception {
        Member m1 = new Member("fall", "단풍이");
        Product p1 = new Product("노트북", 1500000);
        int[] arr1 = { 1, 2, 3 };

        FileOutputStream fos = new FileOutputStream("c:/temp/object.dat");
        ObjectOutputStream oo = new ObjectOutputStream(fos);

        oo.writeObject(m1);
        oo.writeObject(p1);
        oo.writeObject(arr1);

        oo.flush();
        oo.close();
        fos.close();
    }
}
