class GymMemberP5 {

    private static int memberCount = 2000;

    public final String membershipNumber;

    protected int monthlyFee;
    protected int feesPaid;

    public GymMemberP5(int monthlyFee) {

        this.monthlyFee = monthlyFee;
        this.feesPaid = 0;

        memberCount++;

        membershipNumber = "GYM-" + memberCount;
    }

    // One-argument payFee()
    public void payFee(int amount) {

        feesPaid += amount;
    }

    // Two-argument overloaded payFee()
    public void payFee(int amount, String mode) {

        System.out.println("Payment Mode: " + mode);

        payFee(amount);
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    public static boolean isValidReferralCode(String code) {

        // Check length first
        if (code == null || code.length() != 4) {
            return false;
        }

        // First character must be G
        if (code.charAt(0) != 'G') {
            return false;
        }

        // Second character must be a digit
        if (!Character.isDigit(code.charAt(1))) {
            return false;
        }

        // Third character must be a digit
        if (!Character.isDigit(code.charAt(2))) {
            return false;
        }

        // Fourth character must be uppercase
        if (!Character.isUpperCase(code.charAt(3))) {
            return false;
        }

        return true;
    }

    public static int getMembersEnrolled() {

        return memberCount - 2000;
    }
}

class GroupClassMemberP5 extends GymMemberP5 {

    private String className;

    public GroupClassMemberP5(int monthlyFee,
                              String className) {

        super(monthlyFee);
        this.className = className;
    }
}

public class GymWeeklyCheckIn {

    static String processWeeklyCheckIn(
        GymMemberP5[] members) {

        int processed = 0;
        int nullSkipped = 0;
        int group = 0;
        int individual = 0;

        for (GymMemberP5 member : members) {

            // Handle null safely
            if (member == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            if (member instanceof GroupClassMemberP5) {
                group++;
            } else {
                individual++;
            }
        }

        return processed +
               " processed | " +
               nullSkipped +
               " null skipped | " +
               group +
               " group | " +
               individual +
               " individual";
    }

    public static void main(String[] args) {

        GymMemberP5 m1 =
            new GymMemberP5(1000);

        System.out.println(
            m1.membershipNumber
        );

        System.out.println(
            GymMemberP5.getMembersEnrolled()
        );

        System.out.println(
            GymMemberP5.isValidReferralCode("G45B")
        );

        System.out.println(
            GymMemberP5.isValidReferralCode("G4B")
        );

        System.out.println(
            GymMemberP5.isValidReferralCode("X45B")
        );

        m1.payFee(500);

        m1.payFee(500, "UPI");

        System.out.println(
            m1.getFeesPaid()
        );

        GymMemberP5[] members = {

            new GroupClassMemberP5(
                1500,
                "Zumba"
            ),

            null,

            new GymMemberP5(1000)
        };

        System.out.println(
            processWeeklyCheckIn(members)
        );
    }
}