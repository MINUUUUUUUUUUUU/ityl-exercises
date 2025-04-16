package chapter06.exercise.basic.exam01;

public class CarExample {
    public static void main(String[] args) {

//        Car myCar = new Car();

        Car myCar = new Car("그랜저", "검정", 250);
        //Car myCar = new Car();  //기본 생성자 호출 못함

        System.out.println("모델명: " + myCar.model);
        System.out.println("색상: " + myCar.color);
        System.out.println("현재속도: " + myCar.speed);

        // 기본값
//        모델명: null
//        시동여부: false
//        현재속도: 0

    }
}
