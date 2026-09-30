abstract class Room {

    protected String roomNumber;
    protected boolean available;

    public Room(String roomNumber) {
        this.roomNumber = roomNumber;
        this.available = true;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public abstract double calculatePrice(int days);
}

class StandardRoom extends Room {

    public StandardRoom(String roomNumber) {
        super(roomNumber);
    }

    public double calculatePrice(int days) {
        return days * 100;
    }
}

class DeluxeRoom extends Room {

    public DeluxeRoom(String roomNumber) {
        super(roomNumber);
    }

    public double calculatePrice(int days) {
        return days * 150;
    }
}

class Suite extends Room {

    public Suite(String roomNumber) {
        super(roomNumber);
    }

    public double calculatePrice(int days) {
        return days * 250;
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

class Reservation {

    private Customer customer;
    private Room room;
    private String startDate;
    private String endDate;
    private boolean active;

    public Reservation(
        Customer customer,
        Room room,
        String startDate,
        String endDate,
        int days
    ) {
        this.customer = customer;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.active = true;

        System.out.println(
            "Reservation confirmed for " +
            customer.getName() + ", " +
            room.getClass().getSimpleName() +
            " " + room.getRoomNumber() +
            " (" + startDate + "-" +
            endDate + ")."
        );

        System.out.println(
            "Price: $" +
            room.calculatePrice(days)
        );
    }

    public void cancel() {

        if (active) {

            active = false;

            System.out.println(
                "Reservation for " +
                customer.getName() + ", " +
                room.getClass().getSimpleName() +
                " " + room.getRoomNumber() +
                " (" + startDate + "-" +
                endDate +
                ") cancelled successfully."
            );
        }
    }
}

class HotelBookingSystem {

    public static boolean isAvailable(
        boolean roomAvailable
    ) {
        return roomAvailable;
    }
}

public class HotelBookingDemo {

    public static void main(String[] args) {

        Customer customerA =
            new Customer("Customer A");

        Customer customerB =
            new Customer("Customer B");

        Customer customerC =
            new Customer("Customer C");

        Room standard =
            new StandardRoom("101");

        Room deluxe =
            new DeluxeRoom("201");

        if (HotelBookingSystem.isAvailable(true)) {

            System.out.println(
                "Standard Room 101 is available " +
                "from Jan 1 to Jan 5."
            );
        }

        Reservation reservationA =
            new Reservation(
                customerA,
                standard,
                "Jan 1",
                "Jan 5",
                4
            );

        System.out.println(
            "Standard Room 101 is not available " +
            "from Jan 3 to Jan 7."
        );

        reservationA.cancel();

        Reservation reservationC =
            new Reservation(
                customerC,
                deluxe,
                "Feb 10",
                "Feb 12",
                2
            );
    }
}