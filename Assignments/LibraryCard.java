class LibraryCard {

    static String libraryName;
    static String validUntil;

    String studentName;

    // Static block
    static {
        libraryName = "SRM Central Library";
        validUntil = "May 2027";

        System.out.println("Library info loaded");
    }

    LibraryCard(String studentName) {
        this.studentName = studentName;
    }

    void printCard() {
        System.out.println(
            "Membership card issued: " + studentName
        );
    }
}

public class LibraryCardDemo {

    public static void main(String[] args) {

        String[] names = {
            "Ananya",
            "Rohan",
            "Priya",
            "Arjun",
            "Sneha"
        };

        for (String name : names) {

            LibraryCard card = new LibraryCard(name);

            card.printCard();
        }
    }
}