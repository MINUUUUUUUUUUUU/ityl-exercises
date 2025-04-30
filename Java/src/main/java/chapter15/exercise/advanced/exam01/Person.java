package chapter15.exercise.advanced.exam01;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person implements Comparable<Person> {
    public String name;
    public int age;

    @Override
    public int compareTo(Person o) {
        if(age < o.age) return -1;
        else if(age > o.age) return 1;
        else return 0;
    }
}
