import java.util.*;

class Payslip {
    String name;
    String type;
    long pay;

    Payslip(String name, String type, long pay) {
        this.name = name;
        this.type = type;
        this.pay = pay;
    }

    @Override
    public String toString() {
        return "Payslip[name=" + name
                + ", type=" + type
                + ", pay=" + pay + "]";
    }
}

public class PayrollRegister {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Payslip> payslips = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();

            if (line.isEmpty()) {
                continue;
            }

            String[] p = line.split("\\s+");

            String type = p[0];
            String name = p[1];
            long pay;

            if (type.equals("FullTime")) {
                pay = Long.parseLong(p[2]);
            } else if (type.equals("PartTime")) {
                long hours = Long.parseLong(p[2]);
                long rate = Long.parseLong(p[3]);
                pay = hours * rate;
            } else if (type.equals("Intern")) {
                pay = Long.parseLong(p[2]);
            } else {
                continue;
            }

            payslips.add(new Payslip(name, type, pay));
        }

        long total = 0;
        Payslip topEarner = null;

        for (Payslip payslip : payslips) {
            System.out.println(payslip);

            total += payslip.pay;

            if (topEarner == null
                    || payslip.pay > topEarner.pay) {
                topEarner = payslip;
            }
        }

        System.out.println("Total " + total);

        if (topEarner != null) {
            System.out.println("top earner " + topEarner.name);
        }

        sc.close();
    }
}