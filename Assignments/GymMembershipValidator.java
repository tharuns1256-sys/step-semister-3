class GymMemberP1 {

    protected String memberId;
    protected int monthlyFee;
    protected int sessionsAttended;

    public GymMemberP1(String memberId, int monthlyFee) {

        if (memberId == null || memberId.trim().length() < 4) {
            throw new IllegalArgumentException("Invalid member ID");
        }

        if (monthlyFee <= 0) {
            throw new IllegalArgumentException("Invalid monthly fee");
        }

        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
        this.sessionsAttended = 0;
    }

    public void attendSession() {
        sessionsAttended++;
    }

    public int getSessionsAttended() {
        return sessionsAttended;
    }

    public static String signUpBatch(String[] memberIds, int monthlyFee) {

        int signedUp = 0;
        int rejected = 0;

        for (String id : memberIds) {

            try {
                new GymMemberP1(id, monthlyFee);
                signedUp++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Signed Up: " + signedUp +
               " | Rejected: " + rejected;
    }
}

class PremiumMemberP1 extends GymMemberP1 {

    private String trainerName;

    public PremiumMemberP1(String memberId, int monthlyFee,
                           String trainerName) {

        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }
}

public class GymMembershipValidator {

    public static void main(String[] args) {

        PremiumMemberP1 p =
            new PremiumMemberP1("MEM01", 2000, "Coach Riya");

        p.attendSession();
        p.attendSession();

        System.out.println(p.getSessionsAttended());

        String[] members = {
            "MEM1", "GM1", "MEM2", " ", "MEM3"
        };

        System.out.println(
            GymMemberP1.signUpBatch(members, 1000)
        );
    }
}