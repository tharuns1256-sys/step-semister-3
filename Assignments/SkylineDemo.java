abstract class Drone {

    public abstract String fly();
}

interface Trackable {

    String getLocation();
}

class DeliveryDrone extends Drone implements Trackable {

    private String id;

    public DeliveryDrone(String id) {
        this.id = id;
    }

    public String fly() {
        return id + " flying";
    }

    public String getLocation() {
        return id + " at Sector 4";
    }
}

class ScoutDrone extends Drone {

    private String id;

    public ScoutDrone(String id) {
        this.id = id;
    }

    public String fly() {
        return id + " scouting";
    }
}

class GroundRobot implements Trackable {

    private String id;

    public GroundRobot(String id) {
        this.id = id;
    }

    public String getLocation() {
        return id + " at Sector 4";
    }
}

class TrackingSystem {

    static String getLocationIfTrackable(Object o) {

        if (o instanceof Trackable) {

            Trackable item = (Trackable) o;

            return item.getLocation();
        }

        return "Tracking not available";
    }
}

public class SkylineDemo {

    public static void main(String[] args) {

        DeliveryDrone d =
            new DeliveryDrone("DR-1");

        ScoutDrone s =
            new ScoutDrone("SC-1");

        GroundRobot g =
            new GroundRobot("GR-1");

        System.out.println(
            TrackingSystem.getLocationIfTrackable(d)
        );

        System.out.println(
            TrackingSystem.getLocationIfTrackable(s)
        );

        System.out.println(
            TrackingSystem.getLocationIfTrackable(g)
        );
    }
}