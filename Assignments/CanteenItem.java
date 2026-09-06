class CanteenItem {

    String itemName;
    int stock;

    CanteenItem(String itemName, int stock) {
        this.itemName = itemName;
        this.stock = stock;
    }

    void restock(int stock) {
        this.stock = this.stock + stock;
    }
}

public class CanteenDemo {

    public static void main(String[] args) {

        CanteenItem[] items = {
            new CanteenItem("Samosa", 15),
            new CanteenItem("Tea Powder", 40),
            new CanteenItem("Bread", 8),
            new CanteenItem("Biscuit Packs", 25)
        };

        for (CanteenItem item : items) {
            item.restock(20);

            System.out.println(
                item.itemName + " | Final Stock: " + item.stock
            );
        }
    }
}