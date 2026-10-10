import java.util.*;

interface Chargeable {
    void charge();
}

class Vehicle {
    String passNumber;
    String owner;
    String type;
    int fee;

    Vehicle(String passNumber, String owner,
            String type, int fee) {
        this.passNumber = passNumber;
        this.owner = owner;
        this.type = type;
        this.fee = fee;
    }

    void displayPass() {
        System.out.println(passNumber + " (" + type
                + ") pass fee " + fee);
    }
}

class ElectricVehicle extends Vehicle implements Chargeable {
    ElectricVehicle(String passNumber, String owner,
                    String type, int fee) {
        super(passNumber, owner, type, fee);
    }

    public void charge() {
        System.out.println(passNumber + " charging bay allotted");
    }
}

public class CampusVehiclePass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Vehicle> vehicles = new HashMap<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();

            if (line.isEmpty()) {
                continue;
            }

            String[] p = line.split("\\s+");

            if (p[0].equals("PASS")) {
                String type = p[1];
                String pass = p[2];
                String owner = p[3];

                int fee = (type.equals("Bike")
                        || type.equals("EBike")
                        || type.equals("E-Bike")) ? 300 : 1000;

                Vehicle v;

                if (type.equals("EBike") || type.equals("ECar")
                        || type.equals("E-Bike")
                        || type.equals("E-Car")) {
                    v = new ElectricVehicle(
                            pass, owner, type, fee);
                } else {
                    v = new Vehicle(pass, owner, type, fee);
                }

                vehicles.put(pass, v);
                v.displayPass();

            } else if (p[0].equals("CHARGE")) {
                String pass = p[1];
                Vehicle v = vehicles.get(pass);

                if (v == null) {
                    System.out.println("Vehicle not found");
                } else if (v instanceof Chargeable) {
                    ((Chargeable) v).charge();
                } else {
                    System.out.println(pass
                            + " rejected: charging unsupported");
                }
            }
        }

        sc.close();
    }
}