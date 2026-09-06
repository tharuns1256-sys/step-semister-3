class PaymentAccount {
}

class HostelAccount extends PaymentAccount {
}

class PaymentManager {

    int hostelCount = 0;
    int dayScholarCount = 0;

    void makePayment(PaymentAccount account, double amount) {

        if (account instanceof HostelAccount) {
            System.out.println("Paid in two installments (hostel account)");
            hostelCount++;
        } else {
            System.out.println("Paid in one go (day-scholar account)");
            dayScholarCount++;
        }
    }

    void showCount() {
        System.out.println(
            "Hostel accounts processed: " + hostelCount +
            " | Day-scholar accounts processed: " + dayScholarCount
        );
    }
}

public class PaymentDemo {

    public static void main(String[] args) {

        PaymentAccount[] accounts = {
            new HostelAccount(),
            new HostelAccount(),
            new PaymentAccount(),
            new PaymentAccount()
        };

        PaymentManager manager = new PaymentManager();

        for (PaymentAccount account : accounts) {
            manager.makePayment(account, 60000);
        }

        manager.showCount();
    }
}