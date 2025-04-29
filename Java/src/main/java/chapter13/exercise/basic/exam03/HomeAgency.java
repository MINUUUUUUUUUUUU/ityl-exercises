package chapter13.exercise.basic.exam03;

public class HomeAgency implements Rentable<Home> {

    Home home = new Home();

    @Override
    public Home rent() {
        return home;
    }
}
