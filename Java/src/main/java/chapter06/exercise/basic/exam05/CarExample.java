package chapter06.exercise.basic.exam05;

public class CarExample {
    public static void main(String[] args) {
        Car car0 = new Car();
        System.out.println("car1.company : "+ car0.company);
        System.out.println();
        Car car1 = new Car("자가용");
        System.out.println("car2.company : " + car1.company);
        System.out.println("car2.model : " + car1.model);
        System.out.println();
        Car car2 = new Car("자가용", "빨강");
        System.out.println("car3.company : " + car2.company);
        System.out.println("car3.model : " + car2.model);
        System.out.println("car3.color : " + car2.color);
        System.out.println();
        Car car3 = new Car("택시", "검정", 200);
        System.out.println("car4.company : " + car3.company);
        System.out.println("car4.model : " + car3.model);
        System.out.println("car4.color : " + car3.color);
        System.out.println("car4.maxSpeed : " + car3.maxSpeed);
    }
}
