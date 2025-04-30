package chapter15.exercise.advanced.exam02;


import java.util.TreeSet;

public class ComparatorExample {

    public static void main(String[] args) {
        TreeSet<Fruit> fruits = new TreeSet<Fruit>(new FruitComparator());
        fruits.add(new Fruit("포도", 3000));
        fruits.add(new Fruit("수박", 10000));
        fruits.add(new Fruit("딸기", 6000));

        for (Fruit fruit : fruits) {
            System.out.println(fruit.name);
        }
    }
}
