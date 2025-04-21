package chapter08.exercise.basic.exam03;

public class SmartTelevision implements RemoteControl, Searchable {

    @Override
    public void turnOn() {
        System.out.println("SmartTelevision turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("SmartTelevision turned off");
    }

    @Override
    public void search(String url) {
        System.out.println("SmartTelevision searching " + url);
    }


}
