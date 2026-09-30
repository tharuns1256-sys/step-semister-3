interface PaymentMethod {

    boolean processPayment(double amount);
}

class CreditCardPayment implements PaymentMethod {

    public boolean processPayment(double amount) {

        System.out.println(
            "Payment processed using Credit Card."
        );

        return true;
    }
}

class PayPalPayment implements PaymentMethod {

    public boolean processPayment(double amount) {

        System.out.println(
            "Payment processed using PayPal."
        );

        return false;
    }
}

class BankTransferPayment implements PaymentMethod {

    public boolean processPayment(double amount) {

        System.out.println(
            "Payment processed using Bank Transfer."
        );

        return true;
    }
}

class Product {

    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}

class OrderItem {

    private Product product;
    private int quantity;

    public OrderItem(
        Product product,
        int quantity
    ) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotal() {
        return product.getPrice() * quantity;
    }
}

class Customer {

    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Order {

    private Customer customer;
    private OrderItem[] items;
    private int itemCount;
    private String status;

    public Order(Customer customer) {

        this.customer = customer;
        this.items = new OrderItem[10];
        this.itemCount = 0;
        this.status = "Pending";
    }

    public void addProduct(
        Product product,
        int quantity
    ) {

        items[itemCount] =
            new OrderItem(product, quantity);

        itemCount++;
    }

    public boolean isEmpty() {
        return itemCount == 0;
    }

    public double getTotal() {

        double total = 0;

        for (int i = 0; i < itemCount; i++) {
            total += items[i].getTotal();
        }

        return total;
    }

    public void pay(PaymentMethod method) {

        if (isEmpty()) {

            System.out.println(
                "Cannot process payment for an empty order."
            );

            return;
        }

        System.out.println(
            "Payment initiated for Order " +
            customer.getName() + "."
        );

        boolean success =
            method.processPayment(getTotal());

        if (success) {

            status = "Paid";

            System.out.println(
                "Payment for Order " +
                customer.getName() +
                " successful."
            );

        } else {

            System.out.println(
                "Payment for Order " +
                customer.getName() +
                " failed."
            );
        }

        System.out.println(
            "Order status: " + status + "."
        );
    }
}

public class ShoppingPaymentDemo {

    public static void main(String[] args) {

        // Customer X
        Customer customerX =
            new Customer("X");

        Order orderX =
            new Order(customerX);

        Product productA =
            new Product("Product A", 100);

        Product productB =
            new Product("Product B", 50);

        orderX.addProduct(productA, 2);
        orderX.addProduct(productB, 1);

        System.out.println(
            "Order created for Customer X."
        );

        CreditCardPayment creditCard =
            new CreditCardPayment();

        orderX.pay(creditCard);

        // Customer Y - empty order
        Customer customerY =
            new Customer("Y");

        Order orderY =
            new Order(customerY);

        orderY.pay(creditCard);

        // Customer Z
        Customer customerZ =
            new Customer("Z");

        Order orderZ =
            new Order(customerZ);

        Product productC =
            new Product("Product C", 200);

        orderZ.addProduct(productC, 1);

        System.out.println(
            "Order created for Customer Z."
        );

        PayPalPayment paypal =
            new PayPalPayment();

        orderZ.pay(paypal);
    }
}