package chapter06.exercise.basic.exam05;

public class Car {
    String company = "현대자동차";
    String model;
    String color;
    int maxSpeed;

    Car() {
        this.model = "자가용";
        this.color = "은색";
        this.maxSpeed = 250;
    }

    Car(String model) { //20라인 생성자 호출
        this(model, "은색", 250);
    }

    Car(String model, String color) { //20라인 생성자 호출
        this(model, color, 250);
    }

    Car(String model, String color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
}

