class LibraryMemberP5 {

    private static int memberCount = 100;

    public final String memberNumber;

    protected int borrowLimit;
    protected int booksBorrowed;

    public LibraryMemberP5(int borrowLimit) {

        this.borrowLimit = borrowLimit;
        this.booksBorrowed = 0;

        memberCount++;

        memberNumber = "LIB-" + memberCount;
    }

    public void borrowBook() {

        if (booksBorrowed < borrowLimit) {
            booksBorrowed++;
        }
    }

    public void borrowBook(String genre) {

        System.out.println("Genre: " + genre);

        borrowBook();
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public static boolean isValidRenewalCode(String code) {

        if (code == null || code.length() != 4) {
            return false;
        }

        if (code.charAt(0) != 'R') {
            return false;
        }

        if (!Character.isDigit(code.charAt(1))) {
            return false;
        }

        if (!Character.isDigit(code.charAt(2))) {
            return false;
        }

        if (!Character.isUpperCase(code.charAt(3))) {
            return false;
        }

        return true;
    }

    public static int getMembersEnrolled() {

        return memberCount - 100;
    }
}

class FacultyMemberP5 extends LibraryMemberP5 {

    private String department;

    public FacultyMemberP5(int borrowLimit, String department) {
        super(borrowLimit);
        this.department = department;
    }
}

public class MembershipAuditSystem {

    static String processNightlyAudit(LibraryMemberP5[] members) {

        int processed = 0;
        int nullSkipped = 0;
        int faculty = 0;
        int regular = 0;

        for (LibraryMemberP5 member : members) {

            if (member == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            if (member instanceof FacultyMemberP5) {
                faculty++;
            } else {
                regular++;
            }
        }

        return processed + " processed | " +
               nullSkipped + " null skipped | " +
               faculty + " faculty | " +
               regular + " regular";
    }

    public static void main(String[] args) {

        LibraryMemberP5 m1 =
            new LibraryMemberP5(3);

        System.out.println(m1.memberNumber);

        System.out.println(
            LibraryMemberP5.getMembersEnrolled()
        );

        System.out.println(
            LibraryMemberP5.isValidRenewalCode("R12A")
        );

        System.out.println(
            LibraryMemberP5.isValidRenewalCode("R1A")
        );

        System.out.println(
            LibraryMemberP5.isValidRenewalCode("X12A")
        );

        m1.borrowBook();

        m1.borrowBook("Fiction");

        System.out.println(
            m1.getBooksBorrowed()
        );

        LibraryMemberP5[] members = {

            new FacultyMemberP5(5, "Physics"),

            null,

            new LibraryMemberP5(3)
        };

        System.out.println(
            processNightlyAudit(members)
        );
    }
}