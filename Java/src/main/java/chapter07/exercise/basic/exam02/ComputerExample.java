package chapter07.exercise.basic.exam02;

public class ComputerExample {
    public static void main(String[] args) {
        int r = 10;
        Calculator calculator = new Calculator();
        System.out.println("원 면적: " + calculator.areaCircle(r));
        System.out.println();
        Computer computer = new Computer();
        System.out.println("원 면적: " + computer.areaCircle(r));
    }
}
