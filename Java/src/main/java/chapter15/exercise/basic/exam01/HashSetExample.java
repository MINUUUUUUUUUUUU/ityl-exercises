package chapter15.exercise.basic.exam01;

import java.util.*;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();

        set.add("Java");
        set.add("JDBC");
        set.add("Servlet/JSP");
        set.add("Java");
        set.add("iBATIS");
        int size = set.size();
        System.out.println("총 객체 수: " + size);
    }
}

// 총 객체 수: 4