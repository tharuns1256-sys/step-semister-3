class MovieBookingProfile {

    private String name;
    private boolean confirmed;
    private String otp;

    // No-argument constructor
    public MovieBookingProfile() {
    }

    // Constructor using this()
    public MovieBookingProfile(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    // Write-only OTP
    public void setOtp(String otp) {
        this.otp = otp;
    }
}

public class MovieBookingDemo {

    public static void main(String[] args) {

        MovieBookingProfile profile =
            new MovieBookingProfile("Rahul Dev");

        System.out.println(profile.getName());

        profile.setConfirmed(true);

        System.out.println(profile.isConfirmed());

        profile.setOtp("4471");
    }
}