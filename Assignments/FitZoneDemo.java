interface MembershipPlan {

    double calculateFee();

    String getPlanName();
}

class MonthlyPlan implements MembershipPlan {

    public double calculateFee() {
        return 1000;
    }

    public String getPlanName() {
        return "Monthly";
    }
}

class QuarterlyPlan implements MembershipPlan {

    public double calculateFee() {
        return 1000 * 3 * 0.90;
    }

    public String getPlanName() {
        return "Quarterly";
    }
}

class AnnualPlan implements MembershipPlan {

    public double calculateFee() {
        return 1000 * 12 * 0.75;
    }

    public String getPlanName() {
        return "Annual";
    }
}

class Member {

    private String name;
    private Membership membership;

    public Member(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void buyMembership(
        MembershipPlan plan
    ) {

        membership =
            new Membership(this, plan);

        System.out.println(
            plan.getPlanName() +
            " membership created for " +
            name + "."
        );

        System.out.printf(
            "Fee: ₹%.2f%n",
            plan.calculateFee()
        );

        System.out.println(
            "Status: Active."
        );
    }

    public Membership getMembership() {
        return membership;
    }
}

class Membership {

    private Member member;
    private MembershipPlan plan;
    private String status;

    public Membership(
        Member member,
        MembershipPlan plan
    ) {
        this.member = member;
        this.plan = plan;
        this.status = "Active";
    }

    public void checkIn() {

        if (status.equals("Active")) {

            System.out.println(
                member.getName() +
                " checked in successfully."
            );

        } else {

            System.out.println(
                "Check-in denied: " +
                member.getName() +
                "'s membership is " +
                status + "."
            );
        }
    }

    public void freeze() {

        if (status.equals("Expired")) {

            System.out.println(
                "Cannot freeze an Expired membership."
            );

            return;
        }

        if (status.equals("Frozen")) {

            System.out.println(
                "Membership is already Frozen."
            );

            return;
        }

        status = "Frozen";

        System.out.println(
            member.getName() +
            "'s membership frozen."
        );

        System.out.println(
            "Status: Frozen."
        );
    }

    public void unfreeze() {

        if (status.equals("Expired")) {

            System.out.println(
                "Cannot unfreeze an Expired membership."
            );

            return;
        }

        if (status.equals("Active")) {
            return;
        }

        status = "Active";

        System.out.println(
            member.getName() +
            "'s membership unfrozen."
        );

        System.out.println(
            "Status: Active."
        );
    }

    public void expire() {

        status = "Expired";

        System.out.println(
            member.getName() +
            "'s membership expired."
        );

        System.out.println(
            "Status: Expired."
        );
    }
}

public class FitZoneDemo {

    public static void main(String[] args) {

        Member asha =
            new Member("Asha");

        Member ravi =
            new Member("Ravi");

        // Asha buys Quarterly
        asha.buyMembership(
            new QuarterlyPlan()
        );

        // Ravi buys Monthly
        ravi.buyMembership(
            new MonthlyPlan()
        );

        // Asha checks in
        asha.getMembership().checkIn();

        // Asha freezes
        asha.getMembership().freeze();

        // Asha tries to check in
        asha.getMembership().checkIn();

        // Ravi expires
        ravi.getMembership().expire();

        // Ravi tries to freeze
        ravi.getMembership().freeze();
    }
}