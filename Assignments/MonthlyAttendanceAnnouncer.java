class GymMemberP4 {

    protected String memberId;
    protected int monthlyFee;
    protected int sessionsAttended;

    public GymMemberP4(String memberId, int monthlyFee) {

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

    public String displayInfo() {

        return "Standard | Sessions: " +
               sessionsAttended;
    }
}

class PremiumMemberP4 extends GymMemberP4 {

    private String trainerName;

    public PremiumMemberP4(String memberId, int monthlyFee,
                           String trainerName) {

        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    public String getTrainerName() {
        return trainerName;
    }

    @Override
    public String displayInfo() {

        return "Premium | Trainer: " +
               trainerName +
               " | Sessions: " +
               sessionsAttended;
    }
}

public class MonthlyAttendanceAnnouncer {

    static String batchPrint(GymMemberP4[] members) {

        StringBuilder result = new StringBuilder();

        for (GymMemberP4 member : members) {

            // Polymorphic method call
            result.append(member.displayInfo());

            // Downcasting only after checking
            if (member instanceof PremiumMemberP4) {

                PremiumMemberP4 premium =
                    (PremiumMemberP4) member;

                result.append(
                    " [Trainer via downcast: " +
                    premium.getTrainerName() +
                    "]"
                );
            }

            result.append(" | ");
        }

        return result.toString();
    }

    public static void main(String[] args) {

        GymMemberP4[] members = {

            new GymMemberP4("MEM6", 1000),

            new PremiumMemberP4(
                "MEM7",
                2000,
                "Coach Riya"
            )
        };

        System.out.println(
            batchPrint(members)
        );
    }
}