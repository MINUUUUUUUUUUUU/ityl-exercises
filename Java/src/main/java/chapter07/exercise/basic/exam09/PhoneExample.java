package chapter07.exercise.basic.exam09;

public class PhoneExample {
    public static void main(String[] args) {

        // 잘못된 코드
//        Phone phone = new Phone();
        SmartPhone smartPhone = new SmartPhone("홍길동");
        smartPhone.turnOn();
        smartPhone.internetSearch();
        smartPhone.turnOff();
    }
}
