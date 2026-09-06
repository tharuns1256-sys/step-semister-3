class BasicPayment {

    void pay(double amount) {
        System.out.println("Paid (cash): Rs " + amount);
    }
}

class CardPayment extends BasicPayment {

    double payWithProcessingFee(double amount) {

        double total = amount + (amount * 0.02);

        System.out.println(
            "Charged (card, incl. fee): Rs " + total
        );

        return total;
    }
}

class PaymentHandler {

    double totalCollected = 0;

    void processTransaction(
        BasicPayment payment,
        double amount
    ) {

        if (payment instanceof CardPayment) {

            CardPayment card =
                (CardPayment) payment;

            double total =
                card.payWithProcessingFee(amount);

            totalCollected = totalCollected + total;

        } else {

            payment.pay(amount);

            totalCollected =
                totalCollected + amount;
        }
    }
}

public class CanteenPaymentDemo {

    public static void main(String[] args) {

        BasicPayment[] payments = {
            new CardPayment(),
            new BasicPayment(),
            new CardPayment(),
            new BasicPayment(),
            new CardPayment()
        };

        double[] amounts = {
            100, 50, 200, 75, 120
        };

        PaymentHandler handler =
            new PaymentHandler();

        for (int i = 0; i < payments.length; i++) {

            handler.processTransaction(
                payments[i],
                amounts[i]
            );
        }

        System.out.println(
            "Total Collected: Rs " +
            handler.totalCollected
        );
    }
}