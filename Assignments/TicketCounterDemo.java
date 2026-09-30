abstract class Seat {
    protected String seatNumber;

    public Seat(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public abstract double getPrice();
}

class RegularSeat extends Seat {

    public RegularSeat(String seatNumber) {
        super(seatNumber);
    }

    public double getPrice() {
        return 150;
    }
}

class PremiumSeat extends Seat {

    public PremiumSeat(String seatNumber) {
        super(seatNumber);
    }

    public double getPrice() {
        return 250;
    }
}

class ReclinerSeat extends Seat {

    public ReclinerSeat(String seatNumber) {
        super(seatNumber);
    }

    public double getPrice() {
        return 400;
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

class Show {
    private String showTime;
    private Seat[] seats;
    private boolean[] booked;

    public Show(String showTime, Seat[] seats) {
        this.showTime = showTime;
        this.seats = seats;
        this.booked = new boolean[seats.length];
    }

    public int findSeat(String seatNumber) {

        for (int i = 0; i < seats.length; i++) {
            if (seats[i].getSeatNumber()
                    .equals(seatNumber)) {
                return i;
            }
        }

        return -1;
    }

    public boolean isAvailable(String seatNumber) {

        int index = findSeat(seatNumber);

        return index != -1 && !booked[index];
    }

    public boolean bookSeat(String seatNumber) {

        int index = findSeat(seatNumber);

        if (index == -1 || booked[index]) {
            return false;
        }

        booked[index] = true;
        return true;
    }

    public void releaseSeat(String seatNumber) {

        int index = findSeat(seatNumber);

        if (index != -1) {
            booked[index] = false;
        }
    }

    public Seat getSeat(String seatNumber) {

        int index = findSeat(seatNumber);

        if (index == -1) {
            return null;
        }

        return seats[index];
    }
}

class Booking {
    private Customer customer;
    private Show show;
    private Seat[] seats;
    private int seatCount;
    private boolean active;

    public Booking(
        Customer customer,
        Show show
    ) {
        this.customer = customer;
        this.show = show;
        this.seats = new Seat[6];
        this.seatCount = 0;
        this.active = true;
    }

    public boolean addSeat(String seatNumber) {

        if (seatCount >= 6) {
            System.out.println(
                "Cannot book more than 6 seats."
            );
            return false;
        }

        if (!show.isAvailable(seatNumber)) {
            System.out.println(
                "Seat " + seatNumber +
                " is already booked for this show."
            );
            return false;
        }

        show.bookSeat(seatNumber);

        seats[seatCount] =
            show.getSeat(seatNumber);

        seatCount++;

        return true;
    }

    public void showBooking() {

        System.out.print(
            "Booking confirmed for " +
            customer.getName() + ": "
        );

        double total = 0;

        for (int i = 0; i < seatCount; i++) {

            System.out.print(
                seats[i].getSeatNumber()
            );

            if (i < seatCount - 1) {
                System.out.print(", ");
            }

            total += seats[i].getPrice();
        }

        System.out.printf(
            ". Total: ₹%.2f%n",
            total
        );
    }

    public void cancel() {

        if (!active) {
            return;
        }

        for (int i = 0; i < seatCount; i++) {
            show.releaseSeat(
                seats[i].getSeatNumber()
            );
        }

        active = false;

        System.out.println(
            customer.getName() +
            "'s booking cancelled."
        );

        System.out.print("Seats ");

        for (int i = 0; i < seatCount; i++) {

            System.out.print(
                seats[i].getSeatNumber()
            );

            if (i < seatCount - 1) {
                System.out.print(", ");
            }
        }

        System.out.println(" released.");
    }
}

public class TicketCounterDemo {

    public static void main(String[] args) {

        Seat[] seats = {
            new RegularSeat("A1"),
            new RegularSeat("A2"),
            new PremiumSeat("F5"),
            new ReclinerSeat("R1")
        };

        Show show =
            new Show("7 PM", seats);

        Customer asha =
            new Customer("Asha");

        Customer ravi =
            new Customer("Ravi");

        Customer neha =
            new Customer("Neha");

        // Asha books A1, A2 and F5
        Booking ashaBooking =
            new Booking(asha, show);

        ashaBooking.addSeat("A1");
        ashaBooking.addSeat("A2");
        ashaBooking.addSeat("F5");

        ashaBooking.showBooking();

        // Ravi tries A2
        Booking raviBooking =
            new Booking(ravi, show);

        raviBooking.addSeat("A2");

        // Ravi books R1
        raviBooking.addSeat("R1");
        raviBooking.showBooking();

        // Asha cancels
        ashaBooking.cancel();

        // Neha books released A2
        Booking nehaBooking =
            new Booking(neha, show);

        nehaBooking.addSeat("A2");
        nehaBooking.showBooking();
    }
}