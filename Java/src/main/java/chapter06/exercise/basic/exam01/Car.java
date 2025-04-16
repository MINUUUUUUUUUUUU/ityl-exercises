package chapter06.exercise.basic.exam01;

public class Car {
    String model;
    String color;
    int speed;
    boolean start;

    // 기본값
    //        모델명: null
    //        시동여부: false
    //        현재속도: 0


    Car(String model, String color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.speed = maxSpeed;
    }
}
