class CinemaScreen {

    private int seatsTotal;
    private int seatsAvailable;

    CinemaScreen(int seatsTotal) {

        if (seatsTotal <= 0) {
            throw new IllegalArgumentException(
                "Seats total must be positive"
            );
        }

        this.seatsTotal = seatsTotal;
        this.seatsAvailable = seatsTotal;
    }

    void bookSeat() {

        if (seatsAvailable > 0) {
            seatsAvailable--;
        }
    }

    void cancelBooking() {

        if (seatsAvailable < seatsTotal) {
            seatsAvailable++;
        }
    }

    int getSeatsAvailable() {
        return seatsAvailable;
    }
}

public class CinemaScreenDemo {

    public static void main(String[] args) {

        CinemaScreen screen = new CinemaScreen(2);

        screen.bookSeat();
        screen.bookSeat();
        screen.bookSeat();

        System.out.println(screen.getSeatsAvailable());

        screen.cancelBooking();
        screen.cancelBooking();
        screen.cancelBooking();

        System.out.println(screen.getSeatsAvailable());
    }
}