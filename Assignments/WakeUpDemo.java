interface Ringable {

    String ring();
}

class AlarmClock implements Ringable {

    private String time;

    public AlarmClock(String time) {
        this.time = time;
    }

    public String ring() {
        return "Alarm ringing for " + time;
    }
}

class Doorbell implements Ringable {

    private String location;

    public Doorbell(String location) {
        this.location = location;
    }

    public String ring() {
        return "Doorbell ringing at " + location;
    }
}

class RingSystem {

    static void ringAll(Ringable[] devices) {

        for (int i = 0; i < devices.length; i++) {
            System.out.println(devices[i].ring());
        }
    }
}

public class WakeUpDemo {

    public static void main(String[] args) {

        AlarmClock a = new AlarmClock("7:00 AM");
        Doorbell d = new Doorbell("Front Door");

        System.out.println(a.ring());
        System.out.println(d.ring());

        Ringable[] devices = {a, d};

        RingSystem.ringAll(devices);
    }
}