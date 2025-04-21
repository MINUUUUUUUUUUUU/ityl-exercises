package chapter08.exercise.basic.exam02;

public class Audio implements RemoteControl {
    private int volume;

    @Override
    public void turnOn() {
        System.out.println("Turning on audio");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off audio");
    }

    public void setVolume(int volume) {
        this.volume = volume;
        if (volume > RemoteControl.MAX_VOLUME) {
            volume = RemoteControl.MAX_VOLUME;
        }
        else if (volume < RemoteControl.MIN_VOLUME) {
            volume = RemoteControl.MIN_VOLUME;
        }
        System.out.println("Audio Volume set to " + this.volume);
    }
}
