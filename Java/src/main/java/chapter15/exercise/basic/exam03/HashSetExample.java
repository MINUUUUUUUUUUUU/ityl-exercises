package chapter15.exercise.basic.exam03;

import java.util.*;

public class HashSetExample {
    public static void main(String[] args) {

        //HashSet 컬렉션 생성
        Set<String> set = new HashSet<String>();
        //객체추가
        set.add("Java");
        set.add("JDBC");
        set.add("JSP");
        set.add("Spring");

        // Iterator 패턴으로 순회하며 각 요소를 출력하세요.
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println();

        // 향상된 for문으로 순회하며 각 요소를 출력하세요.
        for (String s : set) {
            System.out.println(s);
        }
    }
}
