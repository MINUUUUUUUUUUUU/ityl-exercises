package chapter18.exercise.advanced.exam01;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class ObjectInputStreamExample {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("c:/temp/object.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Member m = (Member) ois.readObject();
        System.out.println(m);
        Product p = (Product) ois.readObject();
        System.out.println(p);
        int[] arr = (int[]) ois.readObject();
        System.out.println(Arrays.toString(arr));

        ois.close();
        fis.close();

//        System.out.println(ois.readObject().toString());

    }
}
