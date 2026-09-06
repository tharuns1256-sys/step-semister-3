class LibraryProfile {

    private String membershipId;
    private String name;
    private boolean premiumMember;
    private String securityAnswer;

    private boolean membershipIdSet = false;

    // No-argument constructor
    public LibraryProfile() {
    }

    // Membership ID - write once
    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String id) {

        if (!membershipIdSet) {
            membershipId = id;
            membershipIdSet = true;
        }
    }

    // Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Premium membership
    public boolean isPremiumMember() {
        return premiumMember;
    }

    public void setPremiumMember(boolean premium) {
        this.premiumMember = premium;
    }

    // Write-only security answer
    public void setSecurityAnswer(String answer) {

        // Simple one-way transformation
        this.securityAnswer = Integer.toHexString(
            answer.hashCode()
        );
    }
}

public class LibraryProfileDemo {

    public static void main(String[] args) {

        LibraryProfile member = new LibraryProfile();

        member.setMembershipId("LIB-8841");
        member.setName("Priya Nair");
        member.setPremiumMember(true);

        System.out.println(
            member.getMembershipId()
        );

        // Second ID is ignored
        member.setMembershipId("FAKE-0000");

        System.out.println(
            member.getMembershipId()
        );

        System.out.println(
            member.isPremiumMember()
        );

        member.setSecurityAnswer("BlueMountain");
    }
}