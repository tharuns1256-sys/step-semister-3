class HallTicket {

    String studentName;
    int seatNumber;

    HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

public class HallTicketDemo {

    public static void main(String[] args) {

        HallTicket priya =
                new HallTicket("Priya", 0);

        // Copying the reference
        HallTicket copy = priya;

        // Changing through copy
        copy.seatNumber = 45;

        // Creating a separate object
        HallTicket separate =
                new HallTicket("Priya", 45);

        System.out.println(
                "Priya's seatNumber (via first variable): "
                + priya.seatNumber);

        System.out.println(
                "copy == priya: " + (copy == priya));

        System.out.println(
                "separate == priya: " + (separate == priya));
    }
}