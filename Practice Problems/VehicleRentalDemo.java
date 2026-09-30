abstract class Vehicle {
    protected String name;
    protected boolean available;

    public Vehicle(String name) {
        this.name = name;
        this.available = true;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void rent() {
        available = false;
    }

    public void returnVehicle() {
        available = true;
    }

    public abstract double calculateCharge(int days);
}

class Sedan extends Vehicle {

    public Sedan(String name) {
        super(name);
    }

    public double calculateCharge(int days) {
        return days * 50;
    }
}

class SUV extends Vehicle {

    public SUV(String name) {
        super(name);
    }

    public double calculateCharge(int days) {
        return days * 80;
    }
}

class Truck extends Vehicle {

    public Truck(String name) {
        super(name);
    }

    public double calculateCharge(int days) {
        return days * 100;
    }
}

class Customer {

    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Rental {

    private Vehicle vehicle;
    private Customer customer;
    private int days;

    public Rental(Vehicle vehicle, Customer customer, int days) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.days = days;
    }

    public void showRental() {
        System.out.println(
            vehicle.getName() +
            " rented successfully by " +
            customer.getName() + "."
        );

        System.out.println(
            "Rental charge: $" +
            vehicle.calculateCharge(days)
        );
    }

    public void returnVehicle() {
        vehicle.returnVehicle();

        System.out.println(
            vehicle.getName() +
            " returned by " +
            customer.getName() + "."
        );
    }
}

public class VehicleRentalDemo {

    public static void main(String[] args) {

        Customer c1 = new Customer("Customer 1");
        Customer c2 = new Customer("Customer 2");
        Customer c3 = new Customer("Customer 3");

        Vehicle sedanA = new Sedan("Sedan A");
        Vehicle suvB = new SUV("SUV B");

        // Customer 1 rents Sedan A
        if (sedanA.isAvailable()) {

            sedanA.rent();

            Rental rental1 =
                new Rental(sedanA, c1, 3);

            rental1.showRental();
        }

        // Customer 2 attempts to rent Sedan A
        if (!sedanA.isAvailable()) {
            System.out.println(
                "Sedan A is currently unavailable."
            );
        }

        // Customer 1 returns Sedan A
        sedanA.returnVehicle();

        System.out.println(
            "Sedan A returned by Customer 1."
        );

        // Customer 3 rents SUV B
        if (suvB.isAvailable()) {

            suvB.rent();

            Rental rental3 =
                new Rental(suvB, c3, 5);

            rental3.showRental();
        }
    }
}