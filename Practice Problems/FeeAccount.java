class FeeAccount {

    String regNo;
    double totalFee;

    FeeAccount(String regNo, double totalFee) {
        this.regNo = regNo;
        this.totalFee = totalFee;
    }

    final double calculateLateFee(int daysLate) {
        return totalFee * 0.01 * daysLate;
    }

    final void printSummary(int daysLate) {

        if (daysLate <= 0) {
            System.out.println(regNo + " - On time, no late fee");
        } else {
            double lateFee = calculateLateFee(daysLate);

            System.out.println(
                regNo + " | Total Fee: Rs " + totalFee +
                " | Late Fee: Rs " + lateFee
            );
        }
    }
}

public class LateFeeDemo {

    public static void main(String[] args) {

        FeeAccount[] accounts = {
            new FeeAccount("RA001", 200000),
            new FeeAccount("RA002", 150000),
            new FeeAccount("RA003", 180000),
            new FeeAccount("RA004", 220000)
        };

        int[] daysLate = {10, 0, -2, 5};

        for (int i = 0; i < accounts.length; i++) {
            accounts[i].printSummary(daysLate[i]);
        }
    }
}